package stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Stream的三个操作步骤：
 * 1、创建 Stream：一个数据源（如：集合、数组），获取一个流：
 *
 *      方法一：通过Collection 系列的集合提供的sream（）或者parallelStream
 *          default Stream<E> stream() : 返回一个顺序流
 *          default Stream<E> parallelStream() : 返回一个并行流
 *
 *      方法二：Java8 中的 Arrays 的静态方法 stream() 可以获取数组流：
 *          static <T> Stream<T> stream(T[] array): 返回一个流
 *          重载形式，能够处理对应基本类型的数组：
 *              public static IntStream stream(int[] array)
 *              public static LongStream stream(long[] array)
 *              public static DoubleStream stream(double[] array)
 *
 *       方法三：由值创建流
 *          可以使用静态方法 Stream.of(), 通过显示值创建一个流。它可以接收任意数量的参数
 *          public static<T> Stream<T> of(T... values) : 返回一个流
 *
 *       方法四：由函数创建流：创建无限流   可以使用静态方法 Stream.iterate() 和  Stream.generate(), 创建无限流。
 *          迭代  public static<T> Stream<T> iterate(final T seed, finalUnaryOperator<T> f)
 *          生成  public static<T> Stream<T> generate(Supplier<T> s)
 *
 * 2、中间操作：一个中间操作链，对数据源的数据进行处理
 *
 * 3、终止操作(终端操作)：一个终止操作，执行中间操作链，并产生结果
 *
 */
public class CreateStream {

    @Test
    public void test(){
        //方法一：通过Collection 系列的集合提供的sream（）或者parallelStream
        ArrayList<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        //方法二：Java8 中的 Arrays 的静态方法 stream() 可以获取数组流：
        Employee[] employees = new Employee[10];
        Stream<Employee> stream1 = Arrays.stream(employees);

        //方法三：由值创建流可以使用静态方法 Stream.of(), 通过显示值创建一个流。它可以接收任意数量的参数
        Stream<String> stream2 = Stream.of("aa","bb","cc");

        //方法四：由函数创建流：创建无限流   可以使用静态方法 Stream.iterate() 和  Stream.generate(), 创建无限流。
        Stream<Integer> stream3 = Stream.iterate(0, (x) -> x + 2);
        stream3.limit(10).forEach(System.out::println);
        //stream3.forEach(System.out::println);

        Stream<Double> stream4 = Stream.generate(() -> Math.random());
        //stream4.forEach(System.out::println);
        stream4.limit(10).forEach(System.out::println);
    }
}
