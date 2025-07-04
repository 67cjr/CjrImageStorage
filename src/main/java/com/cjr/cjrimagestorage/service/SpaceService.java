package com.cjr.cjrimagestorage.service;

import com.cjr.cjrimagestorage.model.dto.space.SpaceAddRequest;
import com.cjr.cjrimagestorage.model.entity.Space;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cjr.cjrimagestorage.model.entity.User;

/**
* @author chengjinrui
* @description 针对表【space(空间)】的数据库操作Service
* @createDate 2025-06-23 17:25:30
*/
public interface SpaceService extends IService<Space> {

    /**
     * 创建空间
     *
     * @param spaceAddRequest
     * @param loginUser
     * @return
     */
    long addSpace(SpaceAddRequest spaceAddRequest, User loginUser);

    /**
     * 校验空间
     *
     * @param space
     * @param add   是否为创建时检验
     */
    void validSpace(Space space, boolean add);

    /**
     * 根据空间级别填充空间对象
     *
     * @param space
     */
    void fillSpaceBySpaceLevel(Space space);

    /**
     * 校验空间权限
     *
     * @param loginUser
     * @param space
     */
    void checkSpaceAuth(User loginUser, Space space);
}
