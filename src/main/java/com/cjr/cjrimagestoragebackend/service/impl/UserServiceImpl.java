package com.cjr.cjrimagestoragebackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cjr.cjrimagestoragebackend.model.entity.User;
import com.cjr.cjrimagestoragebackend.service.UserService;
import com.cjr.cjrimagestoragebackend.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author chengjinrui
* @description 针对表【user(用户)】的数据库操作Service实现
* @createDate 2025-06-20 15:20:11
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




