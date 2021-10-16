package com.lambdaPratice1;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author lingqiao
 * @Date 2021/4/7
 * @Version 1.0
 * @Description
 */
public class lambdaPratice1 {

    List<Employee> emps = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    @Test
    public void test(){
        Collections.sort(emps,(e1,e2) ->{
            if(e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            }else {
                return Integer.compare(e1.getAge(),e2.getAge());
            }
        });

        for(Employee e: emps){
            System.out.println(e);
        }
    }

}
