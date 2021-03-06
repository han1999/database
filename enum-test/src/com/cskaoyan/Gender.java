package com.cskaoyan;

public enum Gender {
    MALE(1001, "男"),
    FEMALE(1002, "女");
    int code;
    String msg;

    Gender(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
