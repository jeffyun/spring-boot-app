package com.jeffyun.springbootweb.schema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by jianfeng.Wu on 2017/12/27.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
        Student student = SpringContextHolder.getBean(Student.class);
        System.out.println(student.toString());
    }
}
