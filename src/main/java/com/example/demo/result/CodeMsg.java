package com.example.demo.result;

public enum CodeMsg {
    //通用错误码
    SUCCESS(200,"SUCCESS"),
    SERVER_ERROR(500100,"服务端异常"),
    BIND_ERROR(500101,"参数校验异常：");

    //登录模块 5002xx


    //商品模块5003xx
    private int code;
    private String message;

    CodeMsg(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CodeMsg filterMsg(String message){
        this.message += message;
        return this;
    }
}
