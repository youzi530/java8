package stream;

import org.junit.Test;

/**
 * 映射                                方 法 描 述
 * map(Function f)                    接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
 * mapToDouble(ToDoubleFunction f)    接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 DoubleStream。
 * mapToInt(ToIntFunction f)          接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 IntStream。
 * mapToLong(ToLongFunction f)        接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 LongStream。
 * flatMap(Function f)                接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
 */
public class StreamMapping {

    @Test
    public void test1(){
        
    }
}
