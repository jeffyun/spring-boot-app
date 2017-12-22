package com.jeffyun.springbootweb.model;

import lombok.Builder;
import lombok.Data;

/**
 * Created by jeff.Wu on 2017/12/22.
 */
@Data
@Builder
public class UserInfo {
    private int id;
    private String userCode;
    private String userName;
    private int sex;

}
