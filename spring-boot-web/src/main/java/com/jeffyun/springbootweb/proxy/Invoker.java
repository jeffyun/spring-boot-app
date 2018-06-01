package com.jeffyun.springbootweb.proxy;

/**
 * Created by jeff.Wu on 2018/2/28.
 */
public interface Invoker<T> {
    void invoke();

    void invoke(T t);
}
