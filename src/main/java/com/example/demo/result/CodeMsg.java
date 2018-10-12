package com.example.demo.result;

public enum CodeMsg {
    //通用错误码
    SUCCESS(200,"SUCCESS"),
    SERVER_ERROR(500100,"服务端异常"),
    BIND_ERROR(500101,"参数校验异常："),

    //登录模块 5002xx
    PASSWORD_ERROR(500201,"用户名或密码错误"),
    PHONE_NUM_NOT_EXIST_ERROR(500202,"手机号吗不存在"),


    //商品模块5003xx

    //秒杀模块5004xx
    MIAOSHA_STOCK_NOT_ENOUGH(500401,"秒杀商品数量不足"),
    MIAOSHA_REPEAT(500402,"不能重复秒杀"),
    MIAOSHA_ALREADY(500403,"该商品已经被秒杀");

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
