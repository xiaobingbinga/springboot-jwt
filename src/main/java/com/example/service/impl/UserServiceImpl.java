package com.example.service.impl;

import com.example.domain.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Lucky
 * @version 1.0.0
 * @date 2020/8/31 1:24
 * @copyright 老九学堂
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User login(User loginUser) throws RuntimeException {
        User user = userMapper.login(loginUser);
        if (user != null){
            return user;
        }
        throw new RuntimeException("登录失败");
    }
}
