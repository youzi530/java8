package com.lambdaPratice3;

/**
 * @Author lingqiao
 * @Date 2021/4/7
 * @Version 1.0
 * @Description
 */
public class TestLambda {

    public static void main(String[] args) {
        op(100L, 100L, (x1, x2) -> x1 + x2);

        op(100L, 100L, (x1, x2) -> x1 * x2);
    }

    public static void op(Long l1, Long l2, MyFun2<Long, Long> myFun2) {
        System.out.println(myFun2.getValue(l1, l2));
    }
}
