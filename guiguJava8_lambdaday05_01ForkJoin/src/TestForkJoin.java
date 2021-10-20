import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class TestForkJoin {

    /**
     * 自己写一个forkjoin
     */
    @Test
    public void test() {

        Instant start = Instant.now();

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinCalculate(0L, 100000000L);
        Long sum = pool.invoke(task);
        System.out.println(sum);

        Instant end = Instant.now();
        System.out.println("耗费时间：" + Duration.between(start, end).getNano()); //600 00000
    }

    /**
     * 普通for
     */
    @Test
    public void test1() {
        Instant start = Instant.now();

        long sum = 0L;
        for (int i = 0; i < 100000000L; i++) {
            sum +=i;
        }
        System.out.println(sum);

        Instant end = Instant.now();
        System.out.println("耗费时间：" + Duration.between(start, end).getNano()); //530 00000
    }

    /**
     *  java8 并行流
     */
    @Test
    public void test2() {
        Instant start = Instant.now();

        long reduce = LongStream.rangeClosed(0, 1000000000L)
                .parallel()
                .reduce(0, Long::sum);

        System.out.println(reduce);

        Instant end = Instant.now();
        System.out.println("耗费时间：" + Duration.between(start, end).getNano());
    }
}
