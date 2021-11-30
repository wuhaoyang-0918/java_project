import com.why.pojo.Student;

import java.util.Arrays;
import java.util.List;

/**
 * @author why
 * @date 2021/9/1 22:40
 * @PackageName PACKAGE_NAME
 * @description
 */
public class Ma {
    public static final String AUTO = "123";

    public static void main(String[] args) {
        Student student=new Student();
        //student.workStudent("123");
        student.sho1();
    }


    public static boolean getMax(int[] number, int[] number1) {
        if (number.length != number1.length) {
            return false;
        }
        for (int i = 0; i < number.length; i++) {
            if (number[i] != number1[i]) {
                return false;
            }
        }
        return true;
    }

}
