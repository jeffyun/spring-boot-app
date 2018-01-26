package com.jeffyun.springbootweb.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.jeff.springbootmybatis.mapper.UserMapper;
import com.jeff.springbootmybatis.model.User;
import com.jeff.springbootshiro.shiro.PwdUtil;
import com.jeffyun.common.util.GsonUtils;
import com.jeffyun.springbootweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Optional;

/**
 * Created by jeff.Wu on 2017/12/28.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByUsername(String userName) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("userName", userName);
        List<User> userList = userMapper.selectByExample(example);
        return Optional.ofNullable(userList).map(l ->l.size()==1?l.get(0):null).orElse(null);
    }

    @Override
    public int addUser(User user) {
        Preconditions.checkNotNull(user,"新增用户参数为空");
        Preconditions.checkArgument(StringUtils.hasText(user.getUserName()),"用户名称为空");
        Preconditions.checkArgument(StringUtils.hasText(user.getPassword()),"密码为空");

        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("userName", user.getUserName());
        List<User> userList = userMapper.selectByExample(example);
        if(userList != null && userList.size() > 0){
            throw new RuntimeException("用户名称已经存在");
        }

        String slat = PwdUtil.getSalt();
        user.setPassword(PwdUtil.decodePwd(user.getPassword(),slat));
        user.setSalt(slat);
        return userMapper.insertSelective(user);
    }

    @Override
    public List<User> listUser() {
        PageInfo<User> pageInfo = PageHelper.startPage(1,10).doSelectPageInfo(()->userMapper.selectAll());
        System.out.println(GsonUtils.toJsonString(pageInfo));
        return pageInfo.getList();
    }
}
