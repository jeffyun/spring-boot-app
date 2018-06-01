package com.jeffyun.springbootweb.proxy;

/**
 * Created by jianfeng.Wu on 2018/2/28.
 */
public class HelloInvoker implements  Invoker<String> {
    @Override
    public void invoke() {
        System.out.println("hello ");
    }

    @Override
    public void invoke(String name) {
        System.out.println("hello : " + name);
    }
}
