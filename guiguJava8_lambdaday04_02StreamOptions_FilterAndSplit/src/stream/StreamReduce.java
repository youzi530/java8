package stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 归约
 * reduce(T iden, BinaryOperator b)  可以将流中元素反复结合起来，得到一个值。返回 T
 * reduce(BinaryOperator b)          可以将流中元素反复结合起来，得到一个值。 返回 Optional<T>
 * 备注：map 和 reduce 的连接通常称为 map-reduce 模式，因 Google 用它来进行网络搜索而出名。
 */
public class StreamReduce {

    List<Employee> employees = Arrays.asList(
            new Employee(1, "张三", 18, 9999.99, Employee.Status.FREE),
            new Employee(2, "李四", 11, 9999.99, Employee.Status.BUSY),
            new Employee(3, "王五", 34, 2133, Employee.Status.VOCATION),
            new Employee(4, "赵六", 52, 9999.99, Employee.Status.BUSY),
            new Employee(5, "王五", 34, 2133, Employee.Status.VOCATION),
            new Employee(3, "王五", 34, 2133, Employee.Status.BUSY)
    );

    @Test
    public void test() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //0是起始值，那么刚开始，x就是0，然后1就是y，这样反复加
        Integer sum = list.stream()
                .reduce(0, (x, y) -> x + y);
        System.out.println(sum);
    }

    @Test
    public void test1() {
        Optional<Double> optionalDouble = employees.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);
        System.out.println(optionalDouble.get());
    }
}
