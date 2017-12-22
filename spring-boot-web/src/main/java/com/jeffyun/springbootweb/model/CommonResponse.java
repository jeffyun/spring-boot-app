package com.jeffyun.springbootweb.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Created by jeff.Wu on 2017/12/22.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponse<T> {
    private int code = 0;
    private String message = "SUCCESS";
    private T data = null;
}
