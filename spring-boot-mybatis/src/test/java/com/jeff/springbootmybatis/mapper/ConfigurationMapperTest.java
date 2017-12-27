package com.jeff.springbootmybatis.mapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by jeff.wu on 2017/12/27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigurationMapperTest {

    @Autowired
    private ConfigurationMapper configurationMapper;

    @Test
    public void testSelect() {
        new GsonBuilder().disableHtmlEscaping().create();
        System.out.println(new Gson().toJson(configurationMapper.selectAll()));
    }

}
