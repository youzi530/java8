package TestSImpleDataFormate.solution;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * 分十次去解析那个时间，导致线程安全问题
 */
public class TestSimpleDataFormate {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<Date> task = new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                return DataFormateThreadLocal.convet("20210928");
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<Date>> results = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            results.add(pool.submit(task));
        }

        for (Future<Date> future : results) {
            System.out.println(future.get());
        }

        pool.shutdown();
    }

}
