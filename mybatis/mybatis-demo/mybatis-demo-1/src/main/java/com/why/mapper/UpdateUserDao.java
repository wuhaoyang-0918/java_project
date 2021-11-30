package com.why.mapper;

import com.why.pojo.User;

/**
 * @author 昊洋
 * @date:2021-08-05 15:39
 * @PackageName: com.why.mapper
 * @description:
 * @Version 1.0
 */
public interface UpdateUserDao {
/***
 * Desc: 更新
 * @param user
 * @return {@link int}
 * @author why
 * @date 2021/8/5 15:40
 */

    int updateUser(User user);
    /***
     * Desc: trim更新
     * @param user
     * @return {@link int}
     * @author why
     * @date 2021/8/5 15:40
     */
    int trimUpdateUser(User user);

}
