package stream.practice4;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toCollection;

public class Test1 {

    List<Person> persons = Arrays.asList(
            new Person(1, "张三", "张", "三", "male", 21, 100.22),
            new Person(1, "张三", "张", "三", "male", 34, 100.22),
            new Person(1, "张三", "张", "三", "male", 10, 100.22),
            new Person(1, "张三", "张", "三", "male", 21, 100.22),
            new Person(1, "张三", "张", "三", "male", 21, 100.22),
            new Person(1, "张三", "张", "三", "male", 21, 100.22),
            new Person(1, "张三", "张", "三", "male", 21, 100.22)
    );

    //输出 年龄>19的男程序员中名字排名前3位的姓名
    @Test
    public void test() {
        persons.stream()
                .filter((x) -> (x.getAge() > 19))
                .filter((p) -> ("male").equals(p.getGender()))
                .sorted((p1, p2) -> (p1.getFirstName().compareTo(p2.getFirstName())))
                .limit(3)
                .forEach((p) -> System.out.printf("%s %s;", p.getFirstName(), p.getLastName()));
    }

    //工资最高的
    @Test
    public void test1() {
        Person person = persons.stream()
                .max((p1, p2) -> (int) (p1.getSalary() - p2.getSalary()))
                .get();
        System.out.println(person);
    }

    //将 Java programmers 的 first name 存放到 TreeSet
    @Test
    public void test2() {
        TreeSet<String> treeSetPerson = persons.stream()
                .map(Person::getLastName)
                .collect(toCollection(TreeSet::new));
        Set<String> setPersons = persons.stream()
                .map(Person::getLastName)
                .collect(Collectors.toSet());
        System.out.println(treeSetPerson);
        System.out.println(setPersons);
    }

    //计算付给 Java programmers 的所有money
    @Test
    public void test3() {
        int sum = persons.stream()
                .mapToInt((p) -> (int) p.getSalary())
                .sum();
        System.out.println(sum);

        int totalSalary = persons
                .parallelStream()
                .mapToInt(p -> Integer.parseInt(String.valueOf(p.getSalary())))
                .sum();
    }

    //Comparator多属性排序: 先按名字不分大小写排，再按GID倒序排，最后按年龄正序排
    @Test
    public void test4() {
        persons.sort(Comparator.comparing(Person::getName, String.CASE_INSENSITIVE_ORDER)
                .thenComparing(Person::getGid, (a, b) -> b.compareTo(a))
                .thenComparingInt(Person::getAge));
        persons.stream().forEach(System.out::println);
    }


}
