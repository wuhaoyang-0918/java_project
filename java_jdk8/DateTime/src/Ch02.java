import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author why
 * @date 2021/9/24 10:11
 * @PackageName PACKAGE_NAME
 * @description
 */
public class Ch02 {
    public static void main(String[] args) {
        //（5） 获取日期的年月日周时分秒
        LocalDateTime localDateTime = LocalDateTime.now();
        int dayOfYear = localDateTime.getDayOfYear();
        int dayOfMonth = localDateTime.getDayOfMonth();
        DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();
        System.out.println("今天是" + localDateTime + "\n"
                + "本年当中第" + dayOfYear + "天" + "\n"
                + "本月当中第" + dayOfMonth + "天" + "\n"
                + "本周中星期" + dayOfWeek.getValue() + "-即" + dayOfWeek + "\n");

        //获取当天时间的年月日时分秒
        int year = localDateTime.getYear();
        Month month = localDateTime.getMonth();
        int day = localDateTime.getDayOfMonth();
        int hour = localDateTime.getHour();
        int minute = localDateTime.getMinute();
        int second = localDateTime.getSecond();
        System.out.println("今天是" + localDateTime + "\n"
                + "年 ： " + year + "\n"
                + "月 ： " + month.getValue() + "-即 " + month + "\n"
                + "日 ： " + day + "\n"
                + "时 ： " + hour + "\n"
                + "分 ： " + minute + "\n"
                + "秒 ： " + second + "\n"
        );
        //（6） 时间日期前后的比较与判断
        //判断两个时间点的前后
        LocalDate localDate1 = LocalDate.of(2017, 8, 8);
        LocalDate localDate2 = LocalDate.of(2018, 8, 8);
        boolean date1IsBeforeDate2 = localDate1.isBefore(localDate2);
        System.out.println("date1IsBeforeDate2 : " + date1IsBeforeDate2);
        //（7） 判断是否为闰年
        LocalDate now = LocalDate.now();
        System.out.println("now : " + now + ", is leap year ? " + now.isLeapYear());
        // （8） java8时钟 ： clock()
        //返回当前时间，根据系统时间和UTC
        Clock clock = Clock.systemUTC();
        System.out.println(clock);
        // （9） 时间戳
        Instant instant = Instant.now();
        System.out.println(instant);
        Date date = Date.from(instant);
        Instant instant2 = date.toInstant();
        System.out.println(date);
        System.out.println(instant2);
        // （10） 计算时间、日期间隔
        //计算两个日期的日期间隔-年月日
        LocalDate date1 = LocalDate.of(2018, 2, 13);
        LocalDate date2 = LocalDate.of(2017, 3, 12);
        //内部是用date2-date1，所以得到的结果是负数
        Period period = Period.between(date1, date2);
        System.out.println("相差年数 ： " + period.getYears());
        System.out.println("相差月数 ： " + period.getMonths());
        System.out.println("相差日数 ： " + period.getDays());
        //计算两个时间的间隔
        System.out.println("-------------------------------");
        LocalDateTime date3 = LocalDateTime.now();
        LocalDateTime date4 = LocalDateTime.of(2018, 1, 13, 22, 30, 10);
        Duration duration = Duration.between(date3, date4);
        System.out.println(date3 + " 与 " + date4 + " 间隔  " + "\n"
                + " 天 :" + duration.toDays() + "\n"
                + " 时 :" + duration.toHours() + "\n"
                + " 分 :" + duration.toMinutes() + "\n"
                + " 毫秒 :" + duration.toMillis() + "\n"
                + " 纳秒 :" + duration.toNanos() + "\n"
        );
           //（11） 当计算程序的运行时间时，应当使用时间戳Instant
        Instant ins1 = Instant.now();
        for (int i = 0; i < 10000000; i++) {
            //循环一百万次
        }
        Instant ins2 = Instant.now();
        Duration duration1 = Duration.between(ins1, ins2);
        System.out.println("程序运行耗时为 ： " + duration1.toMillis() + "毫秒");
       // （12） 时间日期的格式化（格式化后返回的类型是String）
        String format = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss").format(LocalDateTime.now());
        System.out.println(format);

        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(formatter3.format(LocalDate.now()));
        System.out.println("-------------------------------");
        DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println(formatter4.format(LocalTime.now()));
        //（13）将时间字符串形式转化为日期对象
        String datetime =  "2018-01-13 21:27:30";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldt = LocalDateTime.parse(datetime, dtf);
        System.out.println(ldt);
    }
}
