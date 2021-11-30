package com.why.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @author 昊洋
 * @date:2021-08-05 22:08
 * @PackageName: com.why.mapper
 * @description:
 * @Version 1.0
 */
public interface DeleteUserDao {
    /***
     * Desc: 删除用户
     * @param id
     * @return {@link int}
     * @author why
     * @date 2021/8/5 22:09
     */

    int delUserById(@Param("id") int id);
}
