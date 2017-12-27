package com.jeff.springbootmybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jeff.wu on 2017/12/27.
 */
@Configuration
@MapperScan(basePackages = "com.jeff.springbootmybatis.mapper")
public class MyBatisConfig {

}
