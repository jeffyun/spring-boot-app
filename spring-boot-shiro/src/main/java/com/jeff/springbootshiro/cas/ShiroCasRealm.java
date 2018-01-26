package com.jeff.springbootshiro.cas;

import com.jeff.springbootmybatis.mapper.UserMapper;
import com.jeff.springbootmybatis.model.User;
import com.jeff.springbootshiro.shiro.SessionUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Optional;

/**
 * Created by jianfeng.Wu on 2018/1/17.
 */
@Component
public class ShiroCasRealm extends CasRealm {
    Logger logger = LoggerFactory.getLogger(ShiroCasRealm.class);
    @Autowired
    private UserMapper userMapper;
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//            CasToken casToken = (CasToken) token;
//            if (token == null) {
//                return null;
//            }
//
//            String ticket = (String)casToken.getCredentials();
//            if (!StringUtils.hasText(ticket)) {
//                return null;
//            }
//
//            TicketValidator ticketValidator = ensureTicketValidator();
//
//            try {
//
//                // contact CAS server to validate service ticket
//                Assertion casAssertion = ticketValidator.validate(ticket, getCasService());
//                // get principal, user id and attributes
//                AttributePrincipal casPrincipal = casAssertion.getPrincipal();
//                String userId = casPrincipal.getName();
//                logger.debug("Validate ticket : {} in CAS server : {} to retrieve user : {}", new Object[]{
//                        ticket, getCasServerUrlPrefix(), userId
//                });
//
//                Map<String, Object> attributes = casPrincipal.getAttributes();
//                // refresh authentication token (user id + remember me)
//                casToken.setUserId(userId);
//                String rememberMeAttributeName = getRememberMeAttributeName();
//                String rememberMeStringValue = (String)attributes.get(rememberMeAttributeName);
//                boolean isRemembered = rememberMeStringValue != null && Boolean.parseBoolean(rememberMeStringValue);
//                if (isRemembered) {
//                    casToken.setRememberMe(true);
//                }
//                // create simple authentication info
//                List<Object> principals = CollectionUtils.asList(userId, attributes);
//                PrincipalCollection principalCollection = new SimplePrincipalCollection(principals, getName());
//                return new SimpleAuthenticationInfo(principalCollection, ticket);
//            } catch (TicketValidationException e) {
//                throw new CasAuthenticationException("Unable to validate ticket [" + ticket + "]", e);
//            }

        AuthenticationInfo info = super.doGetAuthenticationInfo(token);
        String username = (String) info.getPrincipals().getPrimaryPrincipal();

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
        return info;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return super.doGetAuthorizationInfo(principals);
    }
}
