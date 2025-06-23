package com.cjr.cjrimagestorage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cjr.cjrimagestorage.model.entity.SpaceUser;
import com.cjr.cjrimagestorage.service.SpaceUserService;
import com.cjr.cjrimagestorage.mapper.SpaceUserMapper;
import org.springframework.stereotype.Service;

/**
* @author chengjinrui
* @description 针对表【space_user(空间用户关联)】的数据库操作Service实现
* @createDate 2025-06-23 17:25:30
*/
@Service
public class SpaceUserServiceImpl extends ServiceImpl<SpaceUserMapper, SpaceUser>
    implements SpaceUserService{

}




