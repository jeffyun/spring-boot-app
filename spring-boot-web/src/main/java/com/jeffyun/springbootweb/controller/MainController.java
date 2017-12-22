package com.jeffyun.springbootweb.controller;

import com.google.common.collect.Lists;
import com.jeffyun.springbootweb.model.CommonResponse;
import com.jeffyun.springbootweb.model.UserInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jeff on 2017/12/22.
 */
@RestController
@RequestMapping(value = "/user")
public class MainController {

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody CommonResponse listUser() {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode(1);

        List<UserInfo> userInfoList = Lists.newArrayList(
                UserInfo.builder().id(1).userCode("code1").userName("name1").sex(1).build(),
                UserInfo.builder().id(2).userCode("code2").userName("name2").sex(1).build());
        commonResponse.setData(userInfoList);
        return commonResponse;
    }
}
