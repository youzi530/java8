package stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * 筛选与切片               方 法 描 述
 * filter(Predicate p)    接收 Lambda ， 从流中排除某些元素。
 * limit(long maxSize)    截断流，使其元素不超过给定数量。
 * distinct()             筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
 * skip(long n)           跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
 */
public class StreamFilter {

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
        Stream<Employee> employeeStream = employees.stream().filter((e) -> e.getAge() > 35);
        employeeStream.forEach(System.out::println);
    }

    //内部迭代：迭代操作由stream api自己完成
    @Test
    public void test1() {
        //多个中间操作可以连接起来形成一个流水线，除非流水线上触发终止操作，否则中间操作不会执行任何的处理！
        //而在终止操作时一次性全部处理，称为“惰性求值”

        //中间操作：
        Stream<Employee> employeeStream = employees.stream().filter((e) -> {
            System.out.println("中间的操作");
            return e.getAge() > 35;
        });
        //结束操作
        employeeStream.forEach(System.out::println);
    }

    //外部迭代
    @Test
    public void test2() {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator);
        }
    }

    @Test
    public void test3() {
        employees.stream()
                .filter((e) -> {
                    System.out.println("短路");
                    return e.getSalary() > 100;
                })
                .limit(3)
                .forEach(System.out::println);
    }

    @Test
    public void test4() {
        employees.stream()
                .filter(e -> {
                    return e.getSalary() > 2000;
                })
                .skip(2)
                .forEach(System.out::println);
    }

    @Test
    public void test5() {
        employees.stream()
                .filter(e -> {
                    return e.getSalary() > 2000;
                })
                .skip(2)
                .distinct()
                .forEach(System.out::println);
    }
}
