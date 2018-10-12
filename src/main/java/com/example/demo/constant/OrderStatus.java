package com.example.demo.constant;

public enum OrderStatus {
    //已取消
    CANCLED(-10),
    //待付款
    UNPAID(10),
    //已付款
    PAID(20),
    //已发货
    SEND(30),
    //交易成功
    SUCCEED(40),
    //交易关闭
    CLOSED(50);
    private final int status;

    OrderStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
