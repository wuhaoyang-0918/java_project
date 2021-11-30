package com.why.mapper;

import com.why.pojo.User;

import java.util.List;

/**
 * @author 昊洋
 * @date:2021-08-05 17:31
 * @PackageName: com.why.mapper
 * @description:
 * @Version 1.0
 */
public interface InsertUserDao {
    /***
     * Desc:添加
     * @param user
     * @return {@link int}
     * @author why
     * @date 2021/8/5 17:35
     */

    int addUser(User user);
    /***
     * Desc:插入获取主键
     * @param user
     * @return {@link int}
     * @author why
     * @date 2021/8/5 22:26
     */

    int addUserFindId(User user);

    /***
     * Desc:  非空字段进行插入
     * @param user
     * @return {@link int}
     * @author why
     * @date 2021/8/5 23:14
     */

    int insertSelective(User user);
    /***
     * Desc:批量插入用户
     * @param users
     * @return {@link int}
     * @author why
     * @date 2021/8/6 0:02
     */

    int batchInsertUser(List<User> users);

}
