package com.jeffyun.springbootweb.service.impl;

import com.jeff.springbootmybatis.model.Permission;
import com.jeffyun.springbootweb.service.PermissionService;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by jianfeng.Wu on 2017/12/28.
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Override
    public List<Permission> listPermissionByUserId(Integer userId) {
        return null;
    }
}
