package com.jeffyun.springbootweb.controller;

import com.jeff.springbootmybatis.model.User;
import com.jeff.springbootshiro.shiro.SessionUtil;
import com.jeffyun.common.model.CommonResponse;
import com.jeffyun.springbootweb.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Optional;

/**
 * Created by jeff.Wu on 2018/1/5.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse addUser(User user){
        user = Optional.ofNullable(user).orElse(new User());
        user.setCreateBy(SessionUtil.getUserId());
        user.setCreateDatetime(new Date());
        user.setUpdateBy(user.getCreateBy());
        user.setUpdateDatetime(user.getCreateDatetime());
        try {
            if(userService.addUser(user)<= 0){
                return CommonResponse.RESPONSE_FILED;
            }
        } catch (RuntimeException e){
            logger.error("新增用户异常",e);
            return CommonResponse.RESPONSE_FILED;
        }
        return CommonResponse.RESPONSE_OK;
    }


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public CommonResponse listUser(){
        CommonResponse commonResponse = new CommonResponse(1);
        commonResponse.setData(userService.listUser());
        return commonResponse;
    }
}
