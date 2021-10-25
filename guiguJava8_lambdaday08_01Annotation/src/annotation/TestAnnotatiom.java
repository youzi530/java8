package annotation;

import com.sun.istack.internal.NotNull;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * 重复注解  和  类型注解
 */
public class TestAnnotatiom {

    @MyAnnotation("Hello")
    @MyAnnotation("world")
    public void show() {

    }

    @Test
    public void test() throws NoSuchMethodException {
        Class<TestAnnotatiom> clazz = TestAnnotatiom.class;
        Method show = clazz.getMethod("show");

        MyAnnotation[] annotationsByType = show.getAnnotationsByType(MyAnnotation.class);
        for (MyAnnotation m : annotationsByType) {
            System.out.println(m);
        }
    }

    @NotNull
    private Object obj = null;

    //类型注解
    @Test
    @MyAnnotation("Hello")
    @MyAnnotation("world")
    public void show1(@MyAnnotation("abc") String str) {

    }
}
