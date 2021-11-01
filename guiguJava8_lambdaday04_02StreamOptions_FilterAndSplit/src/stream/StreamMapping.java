package stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 映射                                方 法 描 述
 * map(Function f)                    接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。    将元素转换成其他形式或者提取信息，接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
 * mapToDouble(ToDoubleFunction f)    接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 DoubleStream。
 * mapToInt(ToIntFunction f)          接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 IntStream。
 * mapToLong(ToLongFunction f)        接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 LongStream。
 * flatMap(Function f)                接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
 */
public class StreamMapping {

    List<Employee> employees = Arrays.asList(
            new Employee(1, "张三", 18, 9999.99),
            new Employee(2, "李四", 11, 9999.99),
            new Employee(3, "王五", 34, 2133),
            new Employee(4, "赵六", 52, 9999.99),
            new Employee(5, "王五", 34, 2133),
            new Employee(3, "王五", 34, 2133)
    );

    @Test
    public void test1() {
        List<String> list = Arrays.asList("aaa", "bbbb", "cccc", "ddddd");
        list.stream().map((str) -> str.toUpperCase())
                .forEach(System.out::println);

        System.out.println("---------------------------------");
        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);

        System.out.println("---------------------------------");
        Stream<Stream<Character>> streamStream = list.stream()
                .map(StreamMapping::filterCharacter);
        streamStream.forEach((sm) -> {
            sm.forEach(System.out::println);
        });

        System.out.println("---------------------------------");
        Stream<Character> characterStream = list.stream()
                .flatMap(StreamMapping::filterCharacter);
        characterStream.forEach((x) -> System.out.println(x));
    }

    public static Stream<Character> filterCharacter(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }

    @Test
    public void test2() {
        List<String> list = Arrays.asList("aaa", "bbbb", "cccc", "ddddd");
        List<Object> list2 = new ArrayList<>();
        list2.add(11);
        list2.add(22);
        list2.add(list);

        System.out.println(list2);
    }

    @Test
    public void test3() {
        List<String> list = Arrays.asList("aaa", "bbbb", "cccc", "ddddd");
        List list2 = new ArrayList<>();
        list2.add(11);
        list2.add(22);
        list2.addAll(list);

        System.out.println(list2);
    }

    // map将集合类(例如列表)元素进行转换的。还有一个 reduce() 函数可以将所有值合并成一个
    @Test
    public void test4() {
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
//        costBeforeTax.stream().map((x) -> x)
//                .forEach(System.out::println);
        double bill = costBeforeTax.stream()
                .map(cost -> cost + 12 * cost)
                .reduce((sum, cost) -> sum + cost)  //sum总和
                .get();
        System.out.println("Total : " + bill);
    }
}
