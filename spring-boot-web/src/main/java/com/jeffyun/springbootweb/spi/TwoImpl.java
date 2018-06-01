package com.jeffyun.springbootweb.spi;

/**
 * Created by jianfeng.Wu on 2018/2/23.
 */
public class TwoImpl implements SpiInterFace {
    @Override
    public void SayHello() {
        System.out.println(" two hello");
    }
}
