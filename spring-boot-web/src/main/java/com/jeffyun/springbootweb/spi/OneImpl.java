package com.jeffyun.springbootweb.spi;

/**
 * Created by jianfeng.Wu on 2018/2/23.
 */
public class OneImpl implements SpiInterFace {
    @Override
    public void SayHello() {
        System.out.println(" one hello");
    }
}
