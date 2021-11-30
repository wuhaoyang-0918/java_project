package com.why.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.why.mapper.FindUserDao;
import com.why.pojo.User;
import com.why.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 昊洋
 * @date:2021-08-05 12:42
 * @PackageName: com.why.test
 * @description:
 * @Version 1.0
 */
public class Select {
    /**
     * 分页
     */
    @Test
    public void  sho(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        FindUserDao mapper = sqlSession.getMapper(FindUserDao.class);
        /*查询语句之前(页码， 每页大小)*/
        PageHelper.startPage(2,2);
        List<User> userList = mapper.getUserList();
        PageInfo<User> pageInfo=new PageInfo<>(userList);
        System.out.println("总记录数:"+pageInfo.getTotal());
        System.out.println("总页数:"+pageInfo.getPages());
        System.out.println("当前页:"+pageInfo.getPageNum());
        System.out.println("每页数据多少条:"+pageInfo.getPageSize());
        pageInfo.getList().forEach(stu-> System.out.println("stu="+stu));
    }
    @Test
    public void getUserListMap(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        FindUserDao mapper = sqlSession.getMapper(FindUserDao.class);
        Map<String, Object> map=new HashMap<>();
        map.put("name","why");
        map.put("pwd","1999");
        mapper.getUserListMap(map).forEach(stu-> System.out.println("stu="+stu));
    }
    /**
     *if
     */
    @Test
    public void  queryIf(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        FindUserDao mapper = sqlSession.getMapper(FindUserDao.class);
        System.out.println(mapper.userLikeById("WH"));
    }

    /**
     * Chooe查询
     */

    @Test
    public void  queryChoOe(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        FindUserDao mapper = sqlSession.getMapper(FindUserDao.class);
        User user=new User();
        user.setName("");
        user.setPwd("200024");
        System.out.println(mapper.chooseUserList(user));
    }
    /**
     * where+Chooe查询
     */
    @Test
    public void  queryChooseWhere(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        FindUserDao mapper = sqlSession.getMapper(FindUserDao.class);
        User user=new User();
        user.setId(3);
        user.setName("why");
        System.out.println(mapper.chooseWhereUser(user));
        sqlSession.close();
    }
    /**
     * where查询
     */
    @Test
    public void  queryWhere(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        FindUserDao mapper = sqlSession.getMapper(FindUserDao.class);
        User user=new User();
        user.setName("");
        user.setPwd("200024");
        System.out.println(mapper.whereUser(user));
    }
    /**
     * trim查询
     */
    @Test
    public void  queryTrim(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        FindUserDao mapper = sqlSession.getMapper(FindUserDao.class);
        User user=new User();
        user.setName("");
        user.setPwd("200024");
        System.out.println(mapper.trimUser(user));
    }
    /**
     * foreachList查询
     */
    @Test
    public void  queryForeach(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        FindUserDao mapper = sqlSession.getMapper(FindUserDao.class);
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        mapper.foreachByListUser(list).forEach(System.out::println);


    }
    /**
     * 总数
     */
    @Test
    public void  getUserCount(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        FindUserDao mapper = sqlSession.getMapper(FindUserDao.class);
        System.out.println(mapper.getUserCount());
    }
    /**
     * id查找姓名
     */
    @Test
    public void  getUserNameById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        FindUserDao mapper = sqlSession.getMapper(FindUserDao.class);
        System.out.println(mapper.getUserNameById(1));
    }
    /**
     * 分组
     */
    @Test
    public void  queryUserOrderName(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        FindUserDao mapper = sqlSession.getMapper(FindUserDao.class);
        mapper.queryUserOrderName("李四","name").forEach(System.out::println);
    }
    /**
     *单条记录map结构
     */
    @Test
    public void  queryUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        FindUserDao mapper = sqlSession.getMapper(FindUserDao.class);
        System.out.println(mapper.queryUserById(1));
    }
    /**
     * 一级缓存 默认开启了
     */
   @Test
    public void getUserById(){
       SqlSession sqlSession = MybatisUtils.getSqlSession();
       FindUserDao mapper = sqlSession.getMapper(FindUserDao.class);
       User userById = mapper.getUserById(1);
       User userById1 = mapper.getUserById(1);

       System.out.println("-->"+userById);
      // sqlSession.clearCache();//手动清除一级缓存
       System.out.println("--------------------------");
       System.out.println("-->"+userById1);
       System.out.println(userById==userById1);//true
   }
    /**
     * 手动开启二级缓存
     */
    @Test
    public void getUserById1(){
        SqlSession sqlSession1 = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();

        FindUserDao mapper1 = sqlSession1.getMapper(FindUserDao.class);
        User userById = mapper1.getUserById(1);
        System.out.println("-->"+userById);
        sqlSession1.close();//关闭SqlSession一级缓存，将查询数据保存到二级缓存中



        FindUserDao mapper2 = sqlSession2.getMapper(FindUserDao.class);
        User userById1 = mapper2.getUserById(1);
        System.out.println("-->"+userById1);
        System.out.println(userById==userById1);//false
        sqlSession2.close();
    }
}
