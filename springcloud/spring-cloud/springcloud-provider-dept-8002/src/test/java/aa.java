import com.why.springcloud.dao.DeptDao;
import com.why.springcloud.pojo.Dept;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 昊洋
 * @date:2020-08-26 22:02
 * @PackageName: PACKAGE_NAME
 * @ClassName: aa
 * @description:
 * @version: 1.0
 */
@SpringBootTest
public class aa {
    @Autowired
    private DeptDao deptDao;
    @Test
    public  void sho(){
        Dept dept1 = deptDao.queryById((long) 1);

    }
}
