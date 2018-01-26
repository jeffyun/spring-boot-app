package com.jeff.springbootshiro.shiro;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * Created by jeff.Wu on 2018/1/5.
 */
public class PwdUtil {

    public static final String ALGORITHM_NAME = "MD5";

    public static final int HASH_ITERATIONS = 2;

    public static String decodePwd(String password,String salt){
        SimpleHash hash = new SimpleHash(ALGORITHM_NAME, password, salt, HASH_ITERATIONS);
        return hash.toHex();
    }

    public static String getSalt(){
        return new SecureRandomNumberGenerator().nextBytes().toHex();
    }

}
