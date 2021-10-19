package stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 收集                     方 法 描 述
 * collect(Collector c)    将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
 * <p>
 * Collector 接口中方法的实现决定了如何对流执行收集操作(如收集到 List、Set、Map)。
 * 但是 Collectors 实用类提供了很多静态方法，可以方便地创建常见收集器实例，具体方法与实例如下表：
 * 方法                       返回类型               作用
 * toList                     List<T>              把流中元素收集到List
 * List<Employee> emps= list.stream().collect(Collectors.toList());
 * toSet                      Set<T>               把流中元素收集到Set
 * Set<Employee> emps= list.stream().collect(Collectors.toSet());
 * toCollection               Collection<T>        把流中元素收集到创建的集合
 * Collection<Employee>emps=list.stream().collect(Collectors.toCollection(ArrayList::new));
 * counting                   Long                 计算流中元素的个数
 * long count = list.stream().collect(Collectors.counting());
 * summingInt                 Integer              对流中元素的整数属性求和
 * inttotal=list.stream().collect(Collectors.summingInt(Employee::getSalary));
 * averagingInt               Double               计算流中元素Integer属性的平均值
 * doubleavg= list.stream().collect(Collectors.averagingInt(Employee::getSalary));
 * summarizingInt            IntSummaryStatistics   收集流中Integer属性的统计值。如：平均值
 * IntSummaryStatisticsiss= list.stream().collect(Collectors.summarizingInt(Employee::getSalary));
 * joining                   String                 连接流中每个字符串
 * String str= list.stream().map(Employee::getName).collect(Collectors.joining());
 * maxBy                     Optional<T>            根据比较器选择最大值
 * Optional<Emp>max= list.stream().collect(Collectors.maxBy(comparingInt(Employee::getSalary)));
 * minBy                     Optional<T>            根据比较器选择最小值
 * Optional<Emp> min = list.stream().collect(Collectors.minBy(comparingInt(Employee::getSalary)));
 * reducing                  归约产生的类型            从一个作为累加器的初始值开始，利用BinaryOperator与流中元素逐个结合，从而归约成单个值
 * inttotal=list.stream().collect(Collectors.reducing(0, Employee::getSalar, Integer::sum));
 * collectingAndThen         转换函数返回的类型         包裹另一个收集器，对其结果转换函数
 * inthow= list.stream().collect(Collectors.collectingAndThen(Collectors.toList(), List::size));
 * groupingBy                Map<K, List<T>>         根据某属性值对流分组，属性为K，结果为V
 * Map<Emp.Status, List<Emp>> map= list.stream().collect(Collectors.groupingBy(Employee::getStatus));
 * partitioningBy            Map<Boolean, List<T>>   根据true或false进行分区
 * Map<Boolean,List<Emp>>vd= list.stream().collect(Collectors.partitioningBy(Employee::getManage));
 */
public class StreamCollect {

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
        List<String> list = employees.stream()
                .map(Employee::getName)
                .distinct()
                .collect(Collectors.toList());
        list.forEach(System.out::println);
    }

    @Test
    public void test1() {
        Set<String> set = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());
        set.forEach(System.out::println);
    }

    @Test
    public void test2() {
        HashSet<String> hashSet = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));
        hashSet.forEach(System.out::println);
    }

    @Test
    public void test3() {
        LinkedHashSet<String> linkedHashSet = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        linkedHashSet.forEach(System.out::println);
    }

    @Test
    public void test4() {
        //计数
        Long collect = employees.stream()
                .collect(Collectors.counting());
        System.out.println(collect);

        //平均数
        Double avergSalary = employees.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(avergSalary);

        //求和
        Double sumSalary = employees.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(sumSalary);

        //最大值
        Optional<Employee> max = employees.stream()
                .collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
        System.out.println(max);
        System.out.println(max.get());

        //最小值
        Optional<Double> min = employees.stream()
                .map(Employee::getSalary)
                .collect(Collectors.minBy(Double::compare));
        System.out.println(min);
        System.out.println(min.get());
    }

    @Test
    /**
     * 分组
     */
    public void test5() {
        Map<Employee.Status, List<Employee>> collect = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(collect);

        //俄罗斯套娃
        Map<Employee.Status, Map<String, List<Employee>>> collect1 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
                    if (e.getAge() <= 35) {
                        return "青年";
                    } else if (e.getAge() <= 50) {
                        return "中年";
                    } else {
                        return " 老年";
                    }
                })));
        System.out.println(collect1);
    }

    @Test
    /**
     * 分区  满足的属于一个区，不满足的属于一个区
     */
    public void test6() {
        Map<Boolean, List<Employee>> collect = employees.stream()
                .collect(Collectors.partitioningBy((e) -> e.getSalary() > 5000));
        System.out.println(collect);

        DoubleSummaryStatistics collect1 = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(collect1.getSum());
    }

    @Test
    public void test7() {
        DoubleSummaryStatistics collect1 = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(collect1.getSum());
        System.out.println(collect1.getMax());
        System.out.println(collect1.getAverage());
    }

    @Test
    public void test8() {
        String collect = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining("+"));
        System.out.println(collect);
    }
}
