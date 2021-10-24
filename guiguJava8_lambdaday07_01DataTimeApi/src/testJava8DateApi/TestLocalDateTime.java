package testJava8DateApi;

import org.junit.Test;

import java.time.*;

public class TestLocalDateTime {

    // 1、LocalDate、LocalTime、LocalDateTime

    /**
     * LocalDate、LocalTime、LocalDateTime 类的实例是不可变的对象，分别表示使用 ISO-8601日历系统的日期、时间、日期和时间。
     * 它们提供了简单的日期或时间，并不包含当前的时间信息。
     * 也不包含与时区相关的信息。
     */
    @Test
    public void test() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDateTime of = LocalDateTime.of(2015, 10, 19, 12, 22, 33);
        System.out.println(of);

        LocalDateTime localDateTime = now.plusYears(2);
        System.out.println(localDateTime);

        LocalDateTime localDateTime1 = now.minusYears(3);
        System.out.println(localDateTime1);

        System.out.println(now.getMonth());
        System.out.println(now.getDayOfMonth());
    }

    //2、Instant 时间戳

    /**
     * 用于“时间戳”的运算。它是以Unix元年(传统的设定为UTC时区1970年1月1日午夜时分)开始所经历的描述进行运算
     */
    @Test
    public void test1() {
        Instant now = Instant.now();//默认获取 UTC 时区
        System.out.println(now);

        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8)); //东八区时区
        System.out.println(offsetDateTime);

        System.out.println(now.toEpochMilli());
        System.out.println(Instant.ofEpochSecond(60));
    }

    //3、Duration 和 Period
    // Duration:用于计算两个“时间”间隔
    // Period:用于计算两个“日期”间隔
    @Test
    public void test2() throws InterruptedException {
        Instant now = Instant.now();

        Thread.sleep(1000);

        Instant now1 = Instant.now();
        Duration between = Duration.between(now, now1);
        System.out.println(between.toMillis());
    }

    @Test
    public void test3() {
        LocalDateTime now1 = LocalDateTime.now();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LocalDateTime now2 = LocalDateTime.now();

        Duration between = Duration.between(now1, now2);
        System.out.println(between.toMillis());
    }

    @Test
    public void test4() {
        LocalDate now1 = LocalDate.of(2015, 1, 1);
        LocalDate now2 = LocalDate.now();
        Period between = Period.between(now1, now2);
        System.out.println(between);
        System.out.println(between.getMonths());
        System.out.println(between.getDays());
    }

}
