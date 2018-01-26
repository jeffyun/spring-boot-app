package com.jeffyun.common.model;

/**
 * Created by jeff.Wu on 2018/1/5.
 */
public class CommonResponse<T> {

    private int code;

    private String message;

    private T data;

    public CommonResponse() {

    }

    public CommonResponse(int code) {
        this.code = code;
    }

    public CommonResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public CommonResponse(CommonResponseBuilder<T> builder) {
        this.code = builder.code;
        this.message = builder.message;
        this.data = builder.data;
    }
    public static final CommonResponse RESPONSE_OK = new CommonResponse(1,"成功");
    public static final CommonResponse RESPONSE_FILED = new CommonResponse(0,"失败");

    public int getCode() {
        return code;
    }

    public CommonResponse setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public CommonResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public CommonResponse setData(T data) {
        this.data = data;
        return this;
    }



    public static class CommonResponseBuilder<T>{
        private int code;
        private String message;
        private T data;

        public CommonResponseBuilder code(int code) {
            this.code = code;
            return this;
        }
        public CommonResponseBuilder message(String message) {
            this.message = message;
            return this;
        }

        public CommonResponseBuilder data(T data) {
            this.data = data;
            return this;
        }

        public CommonResponse build(){
            return new CommonResponse(this);
        }
    }

}
