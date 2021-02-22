package com.example.mapper;

import com.example.domain.User;

/**
 * @author Lucky
 * @version 1.0.0
 * @date 2020/8/31 1:12
 * @copyright 老九学堂
 */
public interface UserMapper {

    /**
     * 用户登录
     * @param user
     * @return
     */
    User login(User user);

}
