package com.arrayRef;

import org.junit.Test;

import java.util.function.Function;

public class ArrayRef {
    /**
     * 数组引用：
     *
     * Type::new
     */

    @Test
    public void test(){
        Function<Integer,String[]> function = (x)->new String[x];
        String[] apply = function.apply(10);
        System.out.println(apply.length);

        Function<Integer,String[]> function1 = String[]::new;
        String[] apply1 = function1.apply(20);
        System.out.println(apply1.length);
    }

}
