package com.jeffyun.springbootweb.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by jianfeng.Wu on 2018/2/28.
 */
public class ProxyFactory {

    public <T> T getProxy(Invoker<T> invoker,Class<?>[] interfaces){
        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),interfaces,new InvokerInvocationHandler(invoker));
    }
}
