package com.hanxiao.mapper;

import com.hanxiao.bean.User;
import org.apache.ibatis.annotations.Param;

/**
 * @description:
 * @author: hanxiao
 * @date: 2022/3/27
 **/
public interface UserMapper {
    User selectUserWithUserDetailByUsernameUseCounts(@Param("username") String username);

    User selectUserWithUserDetailByUsernameUseCrossQuery(@Param("username") String username);
}
