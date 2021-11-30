package com.why.mapper;

import com.why.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 需要写parameterType  一个参数可以省略parameterType
 * @date:2021-08-05 11:40
 * @PackageName: com.why.mapper.com.why
 * @description:
 * @Version 1.0
 */
public interface FindUserDao {

 /**
  * Desc: 查询全部使用分页插件
  *
  * @param id
  * @return {@link List<User>}
  * @author why
  * @date 2021/8/5 14:25
  */

 List<User> getUserList();

 /***
  * Desc:map传参 返回ListMap
  * @param map
  * @return {@link List<Map<String,Object>>}
  * @author why
  * @date 2021/8/5 20:50
  */

 List<Map<String, Object>> getUserListMap(Map<String, Object> map);

 /**
  * Desc: if查询
  *
  * @param name
  * @return {@link User}
  * @author why
  * @date 2021/8/5 14:26
  */

 User userLikeById(@Param("name") String name);

 /***单条记录Map结构 key等于列 value等于值
  * Desc:
  * @param id
  * @return {@link Map<String,Object>}
  * @author why
  * @date 2021/8/9 11:00
  */

 Map<String, Object> queryUserById(@Param("id") int id);

 /**
  * Desc:choose查询
  *
  * @param user
  * @return {@link User}
  * @author why
  * @date 2021/8/5 14:43
  */

 User chooseUserList(@Param("user") User user);

 User chooseUserList1(User user);

 /***
  * Desc: where嵌套choose使用
  * @param user
  * @return {@link User}
  * @author why
  * @date 2021/8/5 21:21
  */

 User chooseWhereUser(User user);

 /**
  * Desc:where查询
  *
  * @param user
  * @return {@link User}
  * @author why
  * @date 2021/8/5 14:43
  */
 User whereUser(User user);

 /***
  * Desc: trim查询
  * @param user
  * @return {@link User}
  * @author why
  * @date 2021/8/5 15:34
  */

 User trimUser(User user);

 /***
  * Desc: foreachList
  * @param list1
  * @return {@link List<User>}
  * @author why
  * @date 2021/8/5 16:19
  */

 List<User> foreachByListUser(List<Integer> list);

 /***
  * Desc:获取总数
  * @param
  * @return {@link int}
  * @author why
  * @date 2021/8/5 20:11
  */

 int getUserCount();

 /***
  * Desc: 查询返回单个值
  * @param id
  * @return {@link String}
  * @author why
  * @date 2021/8/5 20:15
  */

 String getUserNameById(@Param("id") int id);

 /**
  * #{}与${}使用
  * Desc:
  *
  * @param name
  * @param ordName
  * @return {@link List<User>}
  * @author why
  * @date 2021/8/9 10:25
  */

 List<User> queryUserOrderName(@Param("name") String name, @Param("ordName") String ordName);
 /***
  * Desc:一级缓存
  * @param id
  * @return {@link User}
  * @author why
  * @date 2021/8/11 14:46
  */

 User getUserById(int id);
}
