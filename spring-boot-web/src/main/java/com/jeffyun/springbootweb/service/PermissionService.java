package com.jeffyun.springbootweb.service;


import com.jeff.springbootmybatis.model.Permission;

import java.util.List;

/**
 * Created by jeff.Wu on 2017/12/28.
 */
public interface PermissionService {

    /**
     * 根据用户ID查询权限集合列表
     * @param userId 用户ID
     * @return 权限集合列表
     */
    List<Permission> listPermissionByUserId(Integer userId);
}
