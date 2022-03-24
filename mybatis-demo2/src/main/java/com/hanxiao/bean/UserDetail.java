package com.hanxiao.bean;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/3/24
 **/

public class UserDetail {
    private Integer id;
    private Integer userId;
    private Integer height;
    private Integer weight;
    private String pic;

    @Override
    public String toString() {
        return "UserDetail{" +
                "id=" + id +
                ", userId=" + userId +
                ", height=" + height +
                ", weight=" + weight +
                ", pic='" + pic + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public UserDetail() {
    }
}
