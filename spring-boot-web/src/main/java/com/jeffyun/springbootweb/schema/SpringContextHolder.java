package com.jeffyun.springbootweb.schema;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by Jeff.Wu on 2017/6/12.
 */
@Component(value = "springContextHolder")
public class SpringContextHolder implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextHolder.applicationContext = applicationContext;
    }

    public static <T> T getBean(String name) {
        return (T) applicationContext.getBean(name);
    }
    public static <T> T getBean(Class<T> clazz) {
        return (T) applicationContext.getBean(clazz);
    }
}
