package com.hanxiao.mapper;

import com.hanxiao.bean.Student;
import org.apache.ibatis.annotations.Param;

/**
 * @description:
 * @author: hanxiao
 * @date: 2022/3/28
 **/
public interface StudentMapper {
    Student selectStudentWithCourseList(@Param("studentId") Integer studentId);

    Student selectStudentWithCourseListUseCrossQuery(@Param("studentId") Integer studentId);
}
