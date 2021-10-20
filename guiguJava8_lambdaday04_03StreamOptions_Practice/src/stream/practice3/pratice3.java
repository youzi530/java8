package stream.practice3;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class pratice3 {

    List<Transaction> transactions = null;

    @Before
    public void before() {
        Trader raoul = new Trader("Raoul", "chengdu");
        Trader mario = new Trader("Mario", "shenzheng");
        Trader alan = new Trader("Alan", "wuhan");
        Trader brian = new Trader("Brian", "xian");
        Trader arian = new Trader("Arian", "shenzheng");
        Trader dadwn = new Trader("Arian", "xian");

        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(mario, 2002, 1000),
                new Transaction(mario, 2011, 1000),
                new Transaction(mario, 2012, 1000),
                new Transaction(alan, 2022, 2000),
                new Transaction(arian, 2022, 2000),
                new Transaction(raoul, 2021, 530),
                new Transaction(dadwn, 2021, 530));
    }

    //1、找出2011年来发生所有的交易，并按照交易额排序
    @Test
    public void test() {
        transactions.stream()
                .filter((t) -> t.getYear() == 2011)
                .sorted((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()))
                .forEach(System.out::println);
    }

    //2、交易员在哪些不同的城市工作过？
    @Test
    public void test1() {
        transactions.stream()
                .map((t) -> t.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
    }

    //3、查找所有来自shenzheng的交易员，并按照姓名排序
    @Test
    public void test2() {
        transactions.stream()
                .filter((t) -> t.getTrader().getCity().equals("shenzheng"))
                .map(Transaction::getTrader)
                .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
                .distinct()
                .forEach(System.out::println);
    }

    //4、返回所有交易的姓名字符串，按字母顺序排序
    @Test
    public void test3() {
        transactions.stream()
                .map((t) -> t.getTrader().getName())
                .sorted()
                .forEach(System.out::println);

        String reduce = transactions.stream()
                .map((t) -> t.getTrader().getName())
                .sorted()
                .reduce("", String::concat);
        System.out.println(reduce);

        transactions.stream()
                .map((t) -> t.getTrader().getName())
                .flatMap(pratice3::filterCharacter)
                .sorted()
                .forEach(System.out::println);
    }

    public static Stream<Character> filterCharacter(String str) {
        ArrayList<Character> list = new ArrayList<>();

        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }

    //5、有没有交易员是在wuhan工作？
    @Test
    public void test4() {
        boolean wuhan = transactions.stream()
                .anyMatch((t) -> t.getTrader().getCity().equals("wuhan"));
        System.out.println(wuhan);
    }

    //6、打印生活在xian的交易员所有的交易额
    @Test
    public void test5() {
        Optional<Integer> sum = transactions.stream()
                .filter((e) -> e.getTrader().getCity().equals("xian"))
                .map(Transaction::getValue)
                .reduce(Integer::sum);
        System.out.println(sum.get());
    }

    //7、所有的交易中，最高的交易额是多少
    @Test
    public void test6() {
        Optional<Integer> max = transactions.stream()
                .map((t) -> t.getValue())
                .max(Integer::compare);
        System.out.println(max.get());
    }

    //8、找到交易额最小的交易
    @Test
    public void test7() {
        Optional<Transaction> min = transactions.stream()
                .min((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()));
        System.out.println(min.get());
    }
}
