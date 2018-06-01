package com.jeffyun.springbootweb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by jeff.Wu on 2018/1/10.
 */

@Configuration
@Profile({"production"})
@ComponentScan(basePackages = {"com.jeff.springbootshiro.cas"})
public class CasShiroConfig extends com.jeff.springbootshiro.cas.ShiroCasConfig {

}

