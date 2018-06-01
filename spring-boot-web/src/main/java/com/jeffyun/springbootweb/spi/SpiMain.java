package com.jeffyun.springbootweb.spi;

import java.util.ServiceLoader;

/**
 * Created by jianfeng.Wu on 2018/2/23.
 */
public class SpiMain {
    public static void main(String[] args) throws InterruptedException {
        ServiceLoader<SpiInterFace> loader = ServiceLoader.load(SpiInterFace.class);

        System.out.println("start");
        for (SpiInterFace si : loader){
            si.SayHello();
        }
        System.out.println("end");
        Thread.sleep(1000l);
        Thread.sleep(1000l);

    }
}
