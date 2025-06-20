package com.cjr.cjrimagestorage.controller;

import com.cjr.cjrimagestorage.common.BaseResponse;
import com.cjr.cjrimagestorage.common.ResultUtils;
import com.cjr.cjrimagestorage.exception.ErrorCode;
import com.cjr.cjrimagestorage.exception.ThrowUtils;
import com.cjr.cjrimagestorage.model.dto.user.UserRegisterRequest;
import com.cjr.cjrimagestorage.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 用户注册
     */
    @PostMapping("/register")
    public BaseResponse<Long> userRegister(@RequestBody UserRegisterRequest userRegisterRequest) {
        ThrowUtils.throwIf(userRegisterRequest == null, ErrorCode.PARAMS_ERROR);
        String userAccount = userRegisterRequest.getUserAccount();
        String userPassword = userRegisterRequest.getUserPassword();
        String checkPassword = userRegisterRequest.getCheckPassword();
        long result = userService.userRegister(userAccount, userPassword, checkPassword);
        return ResultUtils.success(result);
    }
}
