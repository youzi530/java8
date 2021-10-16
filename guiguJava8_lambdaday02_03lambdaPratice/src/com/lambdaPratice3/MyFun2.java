package com.lambdaPratice3;

/**
 * @Author lingqiao
 * @Date 2021/4/7
 * @Version 1.0
 * @Description
 */
@FunctionalInterface
public interface MyFun2<T, R> {
    public R getValue(T t1, T t2);
}
