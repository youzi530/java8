package ClassDemo;

import org.junit.Test;

import java.util.Optional;
import java.util.function.Supplier;

public class testDemo {

    //解决这种结构的深层嵌套路径是有点麻烦的。我们必须编写一堆 null 检查来确保不会导致一个 NullPointerException:
    @Test
    public void test() {
        test.Outer outer = new test.Outer();
        if (outer != null && outer.nested != null && outer.nested.inner != null) {
            System.out.println(outer.nested.inner.foo);
        }
    }

    //我们可以通过利用 Java 8 的 Optional 类型来摆脱所有这些 null 检查。
    // map 方法接收一个 Function 类型的 lambda 表达式，并自动将每个 function 的结果包装成一个 Optional 对象。
    // 这使我们能够在一行中进行多个 map 操作。Null 检查是在底层自动处理的。
    @Test
    public void test2() {
        Optional.of(new test.Outer())
                .map(test.Outer::getNested)
                .map(test.Nested::getInner)
                .map(test.Inner::getFoo)
                .ifPresent(System.out::println);
    }

    //还有一种实现相同作用的方式就是通过利用一个 supplier 函数来解决嵌套路径的问题:
    @Test
    public void test3() {
        test.Outer obj = new test.Outer();
        resolve(() -> obj.getNested().getInner().getFoo()).ifPresent(System.out::println);

    }

    //调用 obj.getNested().getInner().getFoo()) 可能会抛出一个 NullPointerException 异常。
    // 在这种情况下，该异常将会被捕获，而该方法会返回 Optional.empty()。
    public static <T> Optional<T> resolve(Supplier<T> resolver) {
        try {
            T result = resolver.get();
            return Optional.ofNullable(result);
        } catch (NullPointerException e) {
            return Optional.empty();
        }
    }
}
