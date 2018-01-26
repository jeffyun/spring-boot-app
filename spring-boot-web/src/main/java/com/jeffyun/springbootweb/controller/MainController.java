package com.jeffyun.springbootweb.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jeff.Wu on 2017/12/28.
 */
@Controller
public class MainController {

    Logger logger = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String username,String password){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
        }catch (AuthenticationException e){
            logger.error("验证异常",e);
            return "login";
        }
        return "/";
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String main(){
        return "main";
    }
}
