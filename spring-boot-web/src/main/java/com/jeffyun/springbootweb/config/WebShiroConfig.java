package com.jeffyun.springbootweb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jeff.Wu on 2018/1/10.
 */

@Configuration
@ComponentScan(basePackages = {"com.jeff.springbootshiro.cas"})
public class WebShiroConfig extends com.jeff.springbootshiro.cas.ShiroCasConfig {

}

