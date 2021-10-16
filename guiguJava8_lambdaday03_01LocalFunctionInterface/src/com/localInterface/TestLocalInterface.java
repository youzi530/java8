package com.localInterface;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Author lingqiao
 * @Date 2021/4/7
 * @Version 1.0
 * @Description
 */
public class TestLocalInterface {

    public static void main(String[] args) {

    }

    //Consumer  有去无回
    public static void happy(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    @Test
    public void testConsumer() {
        happy(1000, (money) -> System.out.println("买酒了"));
    }

    //Supplier  产生指定个数的整数，并放入集合中   产生一些对象的
    public static List<Integer> getNumber(int num, Supplier<Integer> supplier) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            Integer integer = supplier.get();
            result.add(integer);
        }
        return result;
    }

    @Test
    public void testSupplier() {
        List<Integer> number = getNumber(10, () -> (int) (Math.random() * 100));
        for (Integer i : number) {
            System.out.println(i);
        }
    }

    //Function<T,R> 函数型接口  用于处理字符串
    public static String strHandler(String s, Function<String,String> function){
        return function.apply(s);
    }

    @Test
    public void testFunction() {
        String s = strHandler("\t\t\t\t4214kfewbfi服务器功能及其嗯  rwqke  ", (x) -> x.trim());
        System.out.println(s);
    }

    //Predicate<T>断言型接口:将指定的字符串（满足条件的）添加到集合中
    public static List<String> filterStr(List<String> list, Predicate<String> predicate){
        List<String> result = new ArrayList<>();
        for(String str : list){
            if(predicate.test(str)){
                result.add(str);
            }
        }
        return result;
    }

    @Test
    public void testPredicate() {
        List<String> list = Arrays.asList("hello", "lingqiao", "lambda", "ww");
        List<String> reslut = filterStr(list, (str) -> str.length() > 3);
        for (String s:reslut) {
            System.out.println(s);
        }
    }
}
