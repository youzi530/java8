package com.lambdaPratice2;

/**
 * @Author lingqiao
 * @Date 2021/4/7
 * @Version 1.0
 * @Description
 */
public class TestLambda {

    public static void main(String[] args) {
        String s = strHandler("\t\t\t\t\t牛逼", (str -> str.trim()));
        System.out.println(s);

        String s1 = strHandler("gdsgsddsadsb", str -> str.toUpperCase());
        System.out.println(s1);

        String s2 = strHandler("312321,312321,321321", str -> str.substring(0, 3));
        System.out.println(s2);
    }

    public static String strHandler(String str,MyFun myFun){
        return myFun.getValue(str);
    }
}
