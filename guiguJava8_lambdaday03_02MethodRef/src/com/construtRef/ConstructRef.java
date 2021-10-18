package com.construtRef;

import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructRef {
    /**
     * 构造器引用
     *  需要调用的构造器的参数列表 要与函数式接口中的抽象方法的参数列表
     * 格式：ClassName::new
     */

    @Test
    public void test(){
        Supplier<Employee> supplier = ()-> new Employee();
        Employee employee = supplier.get();
        System.out.println(employee);

        //构造器引用:
        Supplier<Employee> supplier1 = Employee::new;  //调用的是无参构造器
        Employee employee1 = supplier1.get();
        System.out.println(employee1);
    }

    @Test
    public void test1(){
        Function<Integer,Employee> fun = (x)->new Employee(x);

        Function<Integer,Employee> function = Employee::new;  //调用的是一个参数的构造器
        Employee apply = function.apply(101);
        System.out.println(apply);

        BiFunction<Integer,Integer,Employee> bf = Employee::new;
        Employee apply1 = bf.apply(1001, 23);
        System.out.println(apply1);
    }
}
