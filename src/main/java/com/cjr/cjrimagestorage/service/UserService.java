package com.cjr.cjrimagestorage.service;

import com.cjr.cjrimagestorage.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author chengjinrui
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2025-06-20 22:40:48
*/
public interface UserService extends IService<User> {

    /**
     * 用户注册
     *
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @param checkPassword 校验密码
     * @return 新用户 id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);


    /**
     * 获取加密后的密码
     *
     * @param userPassword
     * @return
     */
    String getEncryptPassword(String userPassword);
}
