package stream.practice;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 怎么使用map和reduce方法数一数流中有多少个Employee呢？
 *
 */
public class Practice2 {

    List<Employee> employees = Arrays.asList(
            new Employee(1, "张三", 18, 9999.99, Employee.Status.FREE),
            new Employee(2, "李四", 11, 9999.99, Employee.Status.BUSY),
            new Employee(3, "王五", 34, 2133, Employee.Status.VOCATION),
            new Employee(4, "赵六", 52, 9999.99, Employee.Status.BUSY),
            new Employee(5, "王五", 34, 2133, Employee.Status.VOCATION),
            new Employee(3, "王五", 34, 2133, Employee.Status.BUSY)
    );

    @Test
    public void test(){
        Optional<Integer> reduce = employees.stream()
                .map((e) -> 1)
                .reduce(Integer::sum);
        System.out.println(reduce.get());
    }
}
