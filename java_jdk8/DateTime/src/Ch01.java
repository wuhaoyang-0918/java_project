import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * @author why
 * @date 2021/9/24 9:45
 * @PackageName PACKAGE_NAME
 * @description
 */
public class Ch01 {
    public static void main(String[] args) {
        //获取当前时间
        LocalDate now = LocalDate.now();
        LocalTime now1 = LocalTime.now();
        LocalDateTime now2 = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now1);
        System.out.println(now2);
        System.out.println("======================================");
        //根据指定日期/时间创建对象
        LocalDate of = LocalDate.of(2018, 1, 13);
        LocalTime of1=LocalTime.of(9, 43, 20);
        LocalDateTime  of2= LocalDateTime.of(2018, 1, 13, 9, 43, 20);
        System.out.println(of);
        System.out.println(of1);
        System.out.println(of2);
        System.out.println("======================================");
        //日期时间的加减
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime plusYearsResult = localDateTime.plusYears(2L);
        LocalDateTime plusMonthsResult = localDateTime.plusMonths(3L);
        LocalDateTime plusDaysResult = localDateTime.plusDays(7L);
        LocalDateTime plusHoursResult = localDateTime.plusHours(2L);
        LocalDateTime plusMinutesResult = localDateTime.plusMinutes(10L);
        LocalDateTime plusSecondsResult = localDateTime.plusSeconds(10L);
        System.out.println("当前时间是 : " + localDateTime + "\n"
                + "当前时间加2年后为 : " + plusYearsResult + "\n"
                + "当前时间加3个月后为 : " + plusMonthsResult + "\n"
                + "当前时间加7日后为 : " + plusDaysResult + "\n"
                + "当前时间加2小时后为 : " + plusHoursResult + "\n"
                + "当前时间加10分钟后为 : " + plusMinutesResult + "\n"
                + "当前时间加10秒后为 : " + plusSecondsResult + "\n"
        );
        System.out.println("======================================");
        //将年、月、日等修改为指定的值，并返回新的日期（时间）对象
        LocalDateTime nextMonth = localDateTime.plus(1, ChronoUnit.MONTHS);
        LocalDateTime nextYear = localDateTime.plus(1, ChronoUnit.YEARS);
        LocalDateTime nextWeek = localDateTime.plus(1, ChronoUnit.WEEKS);
        System.out.println("now : " + localDateTime + "\n"
                        + "nextYear : " + nextYear + "\n"
                        + "nextMonth : " + nextMonth + "\n"
                        + "nextWeek :" + nextWeek + "\n");
        System.out.println("======================================");
       // （4） 将年、月、日等修改为指定的值，并返回新的日期（时间）对象
        LocalDate localDate = LocalDate.now();
            //当前时间基础上，指定本年当中的第几天，取值范围为1-365,366
        LocalDate withDayOfYearResult = localDate.withDayOfYear(200);
            //当前时间基础上，指定本月当中的第几天，取值范围为1-29,30,31
        LocalDate withDayOfMonthResult = localDate.withDayOfMonth(5);
            //当前时间基础上，直接指定年份
        LocalDate withYearResult = localDate.withYear(2017);
           //当前时间基础上，直接指定月份
        LocalDate withMonthResult = localDate.withMonth(5);
        System.out.println("当前时间是 : " + localDate + "\n"
                + "指定本年当中的第200天 : " + withDayOfYearResult + "\n"
                + "指定本月当中的第5天 : " + withDayOfMonthResult + "\n"
                + "直接指定年份为2017 : " + withYearResult + "\n"
                + "直接指定月份为5月 : " + withMonthResult + "\n"
        );



    }
}
