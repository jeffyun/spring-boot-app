package com.jeff.springbootshiro.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

/**
 * Created by jeff.Wu on 2018/1/5.
 */
public final class SessionUtil {

    public static final String SESSION_KEY_USER = "user";
    public static final String SESSION_KEY_USER_ID = "user_id";
    public static final String SESSION_KEY_USER_NAME = "user_name";
    public static final String SESSION_KEY_CNAME = "cname";

    private SessionUtil(){

    }

    public static Session getSession(){
        return SecurityUtils.getSubject().getSession();
    }

    public static Integer getUserId(){
        return (Integer) getSession().getAttribute(SESSION_KEY_USER_ID);
    }
}
