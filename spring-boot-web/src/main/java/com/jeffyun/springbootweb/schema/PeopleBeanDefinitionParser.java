package com.jeffyun.springbootweb.schema;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;

/**
 * Created by jianfeng.Wu on 2018/2/23.
 */
public class PeopleBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
    @Override
    protected Class<?> getBeanClass(Element element) {
        return Student.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        builder.addPropertyValue("name",element.getAttribute("name"));
        builder.addPropertyValue("age",element.getAttribute("age"));
    }
}
