package testTemporalAdjuster;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;

/**
 * TemporalAdjuster : 时间校正器。有时我们可能需要获取例如：将日期调整到“下个周日”等操作。
 *  TemporalAdjusters : 该类通过静态方法提供了大量的常用 TemporalAdjuster 的实现。
 */
public class TemporalAdjusterTest {

    /**
     * TemporalAdjuster 时间校验器
     */
    @Test
    public void test1() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDateTime localDateTime = now.withDayOfMonth(10);
        System.out.println(localDateTime);

        LocalDateTime with = now.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        System.out.println(with);
    }

    /**
     * 自定义：下一个工作日
     */
    @Test
    public void test2() {
        LocalDateTime now = LocalDateTime.now();

        LocalDateTime with = now.with((l) -> {
            LocalDateTime now1 = (LocalDateTime) l;
            DayOfWeek dayOfWeek = now1.getDayOfWeek();

            if (dayOfWeek.equals(DayOfWeek.FRIDAY)) {
                return now1.plusDays(3);
            } else if (now1.equals(DayOfWeek.SATURDAY)) {
                return now1.plusDays(2);
            } else {
                return now1.plusDays(1);
            }
        });

        System.out.println(with);
    }
}
