package com.hanxiao.bean;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/3/19
 **/

public class Bccount {
    private Integer uid;
    private String username;
    private Integer balance;

    @Override
    public String toString() {
        return "Bccount{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", balance=" + balance +
                '}';
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Bccount() {
    }
}
