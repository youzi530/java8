package com.methodRef;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class MethodRef {

    /**
     * 若lamba体中的内容有方法已经实现，我们就可以使用方法引用-----理解我为方法引用是lambada表达式的另外一种表现形式
     * <p>
     * 三种使用方法：
     * 对象::实例方法名
     * 类::静态方法
     * 类::实例方法
     */

    @Test
    /**
     * 1、对象::实例方法名
     * 注意：println方法的参数和返回值  ==  Consumer这个接口下的accpet方法的参数返回值 一致  !!!!!
     */
    public void testMethodRef() {
        Consumer<String> con = (x) -> System.out.println(x);

        PrintStream ps1 = System.out;
        Consumer<String> con1 = (x) -> ps1.println(x);

        PrintStream ps2 = System.out;
        Consumer<String> con2 = ps2::println;

        Consumer<String> con3 = System.out::println;
        con3.accept("dasacascks");
    }

    @Test
    public void test2() {
        Employee employee = new Employee();
        Supplier<String> supplier = () -> employee.getName();
        String s = supplier.get();
        System.out.println(s);

        Supplier<Integer> supplier1 = employee::getAge;
        Integer integer = supplier1.get();
        System.out.println(integer);
    }


    @Test
    /**
     * 2、类::静态方法
     */
    public void test3() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);

        Comparator<Integer> com1 = Integer::compare;
    }
}
