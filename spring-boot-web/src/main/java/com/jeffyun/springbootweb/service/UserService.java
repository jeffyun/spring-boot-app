package com.jeffyun.springbootweb.service;


import com.jeff.springbootmybatis.model.User;

import java.util.List;

/**
 * Created by jeff.wu on 2017/12/28.
 */

public interface UserService {

    /**
     *  用户名称查询用户
     * @param username 用户名称
     * @return 用户
     */
    User getUserByUsername(String username);

    /**
     * 新增用户
     * @param user
     * @return
     */
    int addUser(User user);

    List<User> listUser();
}
