package com.jeff.springbootshiro.shiro;


import com.jeff.springbootmybatis.mapper.PermissionMapper;
import com.jeff.springbootmybatis.mapper.UserMapper;
import com.jeff.springbootmybatis.model.Permission;
import com.jeff.springbootmybatis.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Optional;


/**
 * 认证、授权
 * Created by jeff.wu on 2017/12/28.
 */
@Component
public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PermissionMapper permissionMapper;
    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        List<Permission> permissionList = permissionMapper.selectAll();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        for (Permission permission : permissionList) {
            authorizationInfo.addStringPermission(permission.getPermCode());
        }
        return authorizationInfo;
    }

    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();

        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("userName", username);
        List<User> userList = userMapper.selectByExample(example);
        User user = Optional.ofNullable(userList).map(l ->l.size()==1?l.get(0):null).orElse(null);

        if (user == null) {
            throw new UnknownAccountException("账号不存在");
        }
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute(SessionUtil.SESSION_KEY_USER, user);
        session.setAttribute(SessionUtil.SESSION_KEY_USER_ID,user.getId());
        session.setAttribute(SessionUtil.SESSION_KEY_USER_NAME,user.getUserName());
        session.setAttribute(SessionUtil.SESSION_KEY_CNAME,user.getCname());
        return new SimpleAuthenticationInfo(username, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
    }
}
