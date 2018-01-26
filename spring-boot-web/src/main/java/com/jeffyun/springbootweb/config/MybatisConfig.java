package com.jeffyun.springbootweb.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MapperScan中配置需要扫描的Mapper
 * Created by jeff.Wu on 2018/1/4.
 */
@Configuration
@MapperScan(basePackages = "com.jeff.springbootmybatis.mapper",sqlSessionFactoryRef = "sqlSessionFactory")
public class MybatisConfig {

}
