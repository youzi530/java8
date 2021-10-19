package stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 排序                     方 法 描 述
 * sorted()                产生一个新流，其中按自然顺序排序 Comparable-自然排序
 * sorted(Comparator comp) 产生一个新流，其中按比较器顺序排序
 */
public class StreamSort {

    List<Employee> employees = Arrays.asList(
            new Employee(1, "张三", 18, 9999.99),
            new Employee(2, "李四", 11, 9999.99),
            new Employee(3, "王五", 34, 2133),
            new Employee(4, "赵六", 52, 9999.99),
            new Employee(5, "王五", 34, 2133),
            new Employee(3, "王五", 34, 2133)
    );

    @Test
    public void test() {
        List<String> list = Arrays.asList("aaaa", "bbbb", "cccc", "dddd");
        list.stream()
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    public void test1() {

        employees.stream()
                .sorted((e1, e2) -> {
                    if (e1.getAge().equals(e2.getAge())) {
                        return e1.getName().compareTo(e2.getName());
                    } else {
                        return e1.getAge().compareTo(e2.getAge());
                    }
                }).forEach(System.out::println);
    }
}
