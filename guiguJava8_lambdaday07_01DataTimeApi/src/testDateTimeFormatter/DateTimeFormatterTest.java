package testDateTimeFormatter;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterTest {

    @Test
    public void test(){
        DateTimeFormatter isoDateTime = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime localDateTime = LocalDateTime.now();

        String format = localDateTime.format(isoDateTime);
        System.out.println(format);

        DateTimeFormatter isoDateTime1 = DateTimeFormatter.ISO_DATE;
        System.out.println(localDateTime.format(isoDateTime1));
    }

    //自己规定一个格式
    @Test
    public void test1(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String date = localDateTime.format(dateTimeFormatter);
        System.out.println(date);

        LocalDateTime parse = localDateTime.parse(date,dateTimeFormatter);
        System.out.println(parse);
    }
}
