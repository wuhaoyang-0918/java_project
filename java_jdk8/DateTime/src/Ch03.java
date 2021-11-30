import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author why
 * @date 2021/9/24 11:19
 * @PackageName PACKAGE_NAME
 * @description
 */
public class Ch03 {
    public static void main(String[] args) {
       //时间转换
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate2 = localDateTime.toLocalDate();
        LocalTime localTime1 = localDateTime.toLocalTime();
        System.out.println(localDate2);
        System.out.println(localTime1);
        //修改年份
        LocalDateTime localDateTime1 = localDateTime.withYear(2022);
        System.out.println("aaaaaaa"+localDateTime1);
        //获取毫秒
        Instant ins1 = Instant.now();
        long currentMilli = ins1.toEpochMilli();
        System.out.println(ins1);
        System.out.println(currentMilli);
        //减少一个月

        localDateTime = localDateTime.minusMonths(1);
        System.out.println(localDateTime);
        //判断日期是早于还是晚于另一个日期isBefore() 和 isAfter() 用于比较日期。调用 isBefore() 方法时，如果给定日期小于当前日期则返回 true。

    }
}
