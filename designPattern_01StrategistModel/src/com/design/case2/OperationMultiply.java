package com.design.case2;

/**
 * @author lq
 * @date 2020/6/25
 */
public class OperationMultiply implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
