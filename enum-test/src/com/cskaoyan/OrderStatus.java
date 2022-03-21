package com.cskaoyan;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/3/3
 **/

public enum OrderStatus {
    INIT(1, "初始化"),
    NOT_PAID(2, "未支付"),
    PAYED(3, "支付");
    int code;
    String msg;

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    OrderStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
