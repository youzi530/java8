package com.design.case1;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lq
 * @date 2020/6/25
 */
public class LambdaMain {

    List<Employee> emps = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    //优化方式一：策略设计模式
    public List<Employee> filterEmployee(List<Employee> emps, MyPredicate<Employee> mp){
        List<Employee> list = new ArrayList<>();

        for (Employee employee : emps) {
            if(mp.test(employee)){
                list.add(employee);
            }
        }
        return list;
    }

    @Test
    public void test4(){
        //需求：获取公司中年龄小于 35 的员工信息
        List<Employee> list = filterEmployee(emps, new FilterEmployeeForAge());
        for (Employee employee : list) {
            System.out.println(employee);
        }

        System.out.println("------------------------------------------");

        //需求：获取公司中工资大于 5000 的员工信息
        List<Employee> list2 = filterEmployee(emps, new FilterEmployeeForSalary());
        for (Employee employee : list2) {
            System.out.println(employee);
        }
    }
}
