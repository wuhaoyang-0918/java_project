package com.tes;

import com.demo.dao.BookMapper;
import com.demo.pojo.Books;
import com.demo.service.BookService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 昊洋
 * @date:2021-08-02 14:39
 * @PackageName: com.tes
 * @description: Spring整和Mybatis
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class BookServiceTest {
    @Autowired
    private BookService bookService;
	@Autowired
    private BookMapper bookMapper;

    /**
     * 第一种单元测试  推荐
     */
    @Test
    public void getAll() {
        System.out.println("-------------输出结果------------");
        System.out.println("-------------输出结果------------"+bookService.queryAllBooks());
		System.out.println("-------------输出结果------------"+bookMapper.queryAllBooks());
    }
    /**
     * 第二种单元测试
     */
    @Test
    public void contextAll1() {
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-mybatis.xml");
      /*  BookMapper bookMapper = (BookMapper) context.getBean("bookMapper");*/
        BookMapper bookMapper =  context.getBean("bookMapper",BookMapper.class);
        System.out.println(bookMapper.queryAllBooks());

    }
    @Test
    public void contextAll() {
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-mybatis.xml");
        SqlSessionFactory sqlSessionFactory= (SqlSessionFactory) context.getBean("sqlSessionFactory");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        /* for(接口 com.demo.dao){
            接口 对象= sqlSession.getMapper(接口.class);
            springmMap.put("接口名首字母小写,对象");
        }*/
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);//得到dao代理对象
        System.out.println(mapper.queryAllBooks());
    }


}
