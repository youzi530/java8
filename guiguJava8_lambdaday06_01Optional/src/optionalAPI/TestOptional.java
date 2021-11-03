package optionalAPI;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 这是一个可以为null的容器对象。如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象。
 * <p>
 * 常用方法：
 * <p>
 * Optional.of(T t) : 创建一个 Optional 实例
 * <p>
 * Optional.empty() : 创建一个空的 Optional 实例
 * <p>
 * Optional.ofNullable(T t):若 t 不为 null,创建 Optional 实例,否则创建空实例
 * <p>
 * isPresent() : 判断是否包含值
 * <p>
 * orElse(T t) : 如果调用对象包含值，返回该值，否则返回t
 * <p>
 * orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回 s 获取的值
 * <p>
 * map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回 Optional.empty()
 * <p>
 * flatMap(Function mapper):与 map 类似，要求返回值必须是Optional
 */
public class TestOptional {

    //简单运用：
    @Test
    public void test() {
        Optional<Employee> op = Optional.of(new Employee());
        System.out.println(op.get());
    }

    //空指针的发生：
    @Test
    public void test1() {
        Optional<Employee> op = Optional.of(null);
        System.out.println(op.get());
    }

    //empty
    @Test
    public void test2() {
        Optional<Employee> op = Optional.empty();
        System.out.println(op.get());
    }

    //ofNullable
    @Test
    public void test3() {
        Optional<Employee> op = Optional.ofNullable(new Employee());
        System.out.println(op.get());
    }

    //isPresent  orElse  有值就get，没值就默认值
    @Test
    public void test4() {
        Optional<Employee> op = Optional.ofNullable(null);
        if (op.isPresent()) {
            System.out.println(op.get());
        }
        Employee employee = op.orElse(new Employee(1001, "张三", 18, 98888.88, Employee.Status.BUSY));
        System.out.println(employee);
    }

    //orElseGet
    @Test
    public void test5() {
        Optional<Employee> op = Optional.ofNullable(null);
        Employee employee = op.orElseGet(() -> new Employee());
        System.out.println(employee);
    }

    //map
    @Test
    public void test6() {
        Optional<Employee> op = Optional.ofNullable(new Employee(1001, "张三", 18, 98888.88, Employee.Status.BUSY));
        Optional<String> s = op.map((e) -> e.getName());
        System.out.println(s.get());

        Optional<String> name = Optional.of("Sanaulla");
        Optional<String> s1 = name.map((value) -> value.toUpperCase());
        System.out.println(s1.get());
    }

    //flatMap
    @Test
    public void test7() {
        Optional<Employee> op = Optional.ofNullable(new Employee(1001, "张三", 18, 98888.88, Employee.Status.BUSY));
        Optional<String> s = op.flatMap((e) -> Optional.of(e.getName()));
        System.out.println(s.get());

        Optional<String> name = Optional.of("Sanaulla");
        Optional<String> s1 = name.flatMap((value) -> Optional.of(value.toUpperCase()));
        System.out.println(s1.get());
    }

    //orElseThrow  如果有值则将其返回，否则抛出supplier接口创建的异常。
    @Test
    public void test8() {
        Optional empty = Optional.ofNullable(null);
        try {
            //orElseThrow与orElse方法类似。与返回默认值不同，
            //orElseThrow会抛出lambda表达式或方法生成的异常
            empty.orElseThrow(NullPointerException::new);
        } catch (Throwable ex) {
            //输出: No value present in the Optional instance
            System.out.println(ex.getMessage());
        }
    }

    //ifPresent isPresent() 如果值存在，返回 true，否则返回 false
    @Test
    public void test9() {
        Optional<Employee> op = Optional.ofNullable(new Employee(1001, "张三", 18, 98888.88, Employee.Status.BUSY));
        Optional<String> name = Optional.of("Sanaulla");
//        name.isPresent((s) -> {
//            System.out.println(s); // 输出 Sanaulla
//        });
    }

    //filter
    @Test
    public void test10() {
        Optional<String> name = Optional.of("Sanaulla");
        Optional<String> longName = name.filter((value) -> value.length() > 6);
        String s = longName.orElse("The name is less than 6 characters");
        System.out.println(s);

        Optional<String> anotherName = Optional.of("Sana");
        Optional<String> shortName = anotherName.filter((value) -> value.length() > 6);
        //输出: name长度不足6字符
        System.out.println(shortName.orElse("The name is less than 6 characters"));
    }
}
