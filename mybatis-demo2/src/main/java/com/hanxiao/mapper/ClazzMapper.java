package com.hanxiao.mapper;

import com.hanxiao.bean.Clazz;
import org.apache.ibatis.annotations.Param;

/**
 * @description:
 * @author: hanxiao
 * @date: 2022/3/28
 **/
public interface ClazzMapper {
    Clazz selectClassWithStudentByIdUseCounts(@Param("id") Integer id);

    Clazz selectClassWithStudentByIdUseCrossQuery(@Param("id") Integer id);
}
