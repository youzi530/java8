package com.consumer;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerTest {

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
        Consumer<Employee> greeter = (p) -> System.out.println("Hello, " + p.getName());
        greeter.accept(new Employee(77, "王五77", 777, 777, Employee.Status.BUSY));
    }
}
