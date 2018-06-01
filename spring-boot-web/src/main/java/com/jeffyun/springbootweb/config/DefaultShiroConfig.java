package com.jeffyun.springbootweb.config;

import com.jeff.springbootshiro.shiro.ShiroConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by jianfeng.Wu on 2018/1/31.
 */
@Configuration
@Profile({"dev"})
@ComponentScan(basePackages = {"com.jeff.springbootshiro.shiro"})
public class DefaultShiroConfig extends ShiroConfig {
}
