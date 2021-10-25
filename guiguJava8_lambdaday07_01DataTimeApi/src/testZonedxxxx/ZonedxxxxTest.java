package testZonedxxxx;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

/**
 * 时区的处理
 *  Java8 中加入了对时区的支持，带时区的时间为分别为：ZonedDate、ZonedTime、ZonedDateTime
 * 其中每个时区都对应着 ID，地区ID都为 “{区域}/{城市}”的格式
 * 例如 ：Asia/Shanghai 等
 * ZoneId：该类中包含了所有的时区信息
 *      getAvailableZoneIds() : 可以获取所有时区时区信息
 *      of(id) : 用指定的时区信息获取 ZoneId 对象
 */
public class ZonedxxxxTest {

    @Test
    public void test(){
        Set<String> set = ZoneId.getAvailableZoneIds();
        set.forEach(System.out::println);
    }

    @Test
    public void test1(){
        Set<String> set = ZoneId.getAvailableZoneIds();
        System.out.println(set);

        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Aden"));
        System.out.println(now);
    }

    @Test
    public void test2(){
        LocalDateTime now = LocalDateTime.now();
        ZonedDateTime zonedDateTime = now.atZone(ZoneId.of("Asia/Aden"));
        System.out.println(zonedDateTime);
    }
}
