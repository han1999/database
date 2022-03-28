package com.hanxiao.bean;

import java.util.List;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/3/28
 **/

public class Clazz {
    private Integer id;
    private String name;

    List<Student> studentList;

    @Override
    public String toString() {
        return "Clazz{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentList=" + studentList +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Clazz() {
    }
}
