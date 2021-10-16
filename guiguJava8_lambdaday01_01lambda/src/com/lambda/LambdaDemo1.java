package com.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author lq
 * @date 2020/6/25
 * 举例说明匿名内部类的写法，来传递com
 * 改进：使用lambda表达式来解决
 */
public class LambdaDemo1 {

    //原来匿名内部类的写法
    @Test
    public void test1() {
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    //lambda表达式
    @Test
    public void test2() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> ts = new TreeSet<>(com);
    }

}