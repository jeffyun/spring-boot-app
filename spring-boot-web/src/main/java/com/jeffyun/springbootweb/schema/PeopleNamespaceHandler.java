package com.jeffyun.springbootweb.schema;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Created by jianfeng.Wu on 2018/2/23.
 */
public class PeopleNamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("student",new PeopleBeanDefinitionParser());
    }
}
