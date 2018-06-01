package com.jeff.springbootshiro.test;

/**
 * Created by jianfeng.Wu on 2018/2/8.
 */
public class ResultVO {
    private String code;
    private String message;


    private ResultVO(ResultBuilder resultBuilder) {
        this.code = resultBuilder.code;
        this.message = resultBuilder.message;
    }

    public static class ResultBuilder implements Builder<ResultVO> {


        private String code;
        private String message;


        public ResultBuilder code(String code) {
            this.code = code;
            return this;
        }

        public ResultBuilder message(String message) {
            this.message = message;
            return this;
        }

        @Override
        public ResultVO build() {
            return new ResultVO(this);
        }
    }
}
