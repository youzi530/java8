package com.test;

import com.pratice.MyFun;
import org.junit.Test;

/**
 * @Author lingqiao
 * @Date 2021/4/7
 * @Version 1.0
 * @Description
 */
public class FunctionInterfaceTest {

    public Integer operation(Integer num, MyFun myFun) {
        return myFun.getValue(num);
    }

    @Test
    public void test2() {
        Integer operation = operation(100, (x) -> x * x);
        System.out.println(operation);
    }
}
