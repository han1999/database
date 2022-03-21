package com.cskaoyan;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/3/3
 **/

public class main {
    public static void main(String[] args) {
        //枚举类没有实例对象
//        Gender gender = new Gender(1003, "unknown");
        Gender male=Gender.MALE;
        Gender female = Gender.FEMALE;
        int code = male.getCode();
        String msg = male.getMsg();

    }
}
