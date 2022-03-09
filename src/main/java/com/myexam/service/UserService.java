package com.myexam.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.myexam.mapper.UserMapper;
import com.myexam.po.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    UserMapper userMapper;

    public boolean isRegister(String username){
        return getByUserName(username) != null;
    }

    public int register(User user){
        return userMapper.insert(user);
    }

    public int saveUserInfo(User user){
        return userMapper.updateById(user);
    }

    public User getByUserName(String username){
        return userMapper.selectOne(new QueryWrapper<User>().eq("username",username));
    }

    public User getByUserId(String userId){
        return userMapper.selectById(userId);
//        return userMapper.selectOne(new QueryWrapper<User>().eq("id",userId));
    }
}
