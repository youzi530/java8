package com.lambda.case1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author lingqiao
 * @Date 2020/6/25
 * @Version 1.0
 * @Description
 */
public class Main {

    List<Employee> emps = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    //原始做法需求1:获取当前公司中员工年龄大于35的员工信息
    public List<Employee> filter1(List<Employee> list){
        List<Employee> emps = new ArrayList<>();

        for(Employee e: list){
            if(e.getAge() > 35){
                emps.add(e);
            }
        }
        return emps;
    }

    //原始做法需求1:获取公司中工资大于 5000 的员工信息
    public List<Employee> filter2(List<Employee> list){
        List<Employee> emps = new ArrayList<>();

        for(Employee e: list){
            if(e.getSalary() > 5000){
                emps.add(e);
            }
        }
        return emps;
    }


    ////需求:获取当前公司中员工年龄大于35的员工信息
    public List<Employee> filterEmployee(List<Employee> emps, MyPredicate<Employee> mp){
        List<Employee> list = new ArrayList<>();

        for (Employee employee : emps) {
            if(mp.test(employee)){
                list.add(employee);
            }
        }
        return list;
    }


    //优化方式一：策略者模式（参考设计模式）

    //优化方式二：匿名内部类
    @Test
    public void test5(){
        List<Employee> list = filterEmployee(emps, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee t) {
                return t.getId() <= 103;
            }
        });

        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    //优化方式三：Lambda 表达式
    @Test
    public void test6(){
        List<Employee> employees = filterEmployee(emps, (e) -> e.getSalary() <= 5000);
        employees.forEach(System.out::println);
    }

    //优化方式四：Stream API
    @Test
    public void test7(){
        emps.stream()
                .filter((e) -> e.getAge() <= 35)
                .forEach(System.out::println);

        System.out.println("----------------------------------------------");

        emps.stream()
                .map(Employee::getName)
                .limit(3)
                .sorted()
                .forEach(System.out::println);
    }
}
