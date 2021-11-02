package stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * 查找与匹配                   方 法 描 述
 * allMatch(Predicate p)      检查是否匹配所有元素
 * anyMatch(Predicate p)      检查是否至少匹配一个元素
 * noneMatch(Predicate p)     检查是否没有匹配所有元素
 * findFirst()                返回第一个元素终端操作会从流的流水线生成结果。其结果可以是任何不是流的值，例如：List、Integer，甚至是 void 。
 * findAny()                  返回当前流中的任意元素
 * count()                    返回流中元素总数
 * max(Comparator c)          返回流中最大值
 * min(Comparator c)          返回流中最小值
 * forEach(Consumer c)        内部迭代(使用 Collection 接口需要用户去做迭代，称为外部迭代。相反，Stream API 使用内部迭代——它帮你把迭代做了)
 */
public class StreamTerminate {

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
        //判断employees的元素的状态是不是全部是busy
        boolean b = employees.stream()
                .allMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b);
    }

    @Test
    public void test1() {
        //判断employees的元素的状态是不是至少有一个是busy
        boolean b = employees.stream()
                .anyMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b);
    }

    @Test
    public void test2() {
        //判断employees的元素的状态是不是没有是busy
        boolean b = employees.stream()
                .noneMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b);
    }

    @Test
    public void test3() {
        Optional<Employee> first = employees.stream()
                .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .findFirst();
        System.out.println(first.get());
    }

    @Test
    public void test4() {
        Optional<Employee> first = employees.stream()
                .filter((e) -> e.getStatus().equals(Employee.Status.BUSY))
                .findAny();
        System.out.println(first.get());
    }

    @Test
    public void test5() {
        long count = employees.stream()
                .count();
        System.out.println(count);
    }

    @Test
    public void test6() {
        Optional<Employee> max = employees.stream()
                .max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(max);
    }

    @Test
    public void test7() {
        //找出最低工资
        Optional<Double> min = employees.stream()
                .map(Employee::getSalary)
                .min(Double::compare);
        System.out.println(min.get());
    }

    @Test
    public void test8() {
        Optional<Employee> max = employees.stream().max(Comparator.comparing(x -> x.getId()));
        System.out.println(max.get());

        Optional<Employee> min = employees.stream().min(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getId() > o2.getId()) return -1;
                if (o1.getId() < o2.getId()) return 1;
                return 0;
            }
        });
        System.out.println(min.get());
    }
}
