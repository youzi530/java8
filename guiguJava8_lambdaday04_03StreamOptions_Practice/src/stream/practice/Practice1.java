package stream.practice;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 给定一个数字列表，如何返回一个由每个数的平方构成的列表呢？
 * 给定【1，2，3，4，5】，应该返回【1，4，9，16，25】
 */
public class Practice1 {

    @Test
    public void test() {
        Integer[] num = new Integer[]{1, 2, 3, 4, 5};
        Stream<Integer> numStream = Arrays.stream(num);
        numStream.map((x) -> x * x)
                .forEach(System.out::println);
    }
}
