package com.jeff.springbootshiro;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sound.midi.Soundbank;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootShiroApplicationTests {

	@Autowired
	private HashedCredentialsMatcher hashedCredentialsMatcher;
	@Test
	public void contextLoads() {
		System.out.println(hashedCredentialsMatcher);
	}

}
