package com.cjr.cjrimagestorage.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cjr.cjrimagestorage.annotation.AuthCheck;
import com.cjr.cjrimagestorage.common.BaseResponse;
import com.cjr.cjrimagestorage.common.ResultUtils;
import com.cjr.cjrimagestorage.constant.UserConstant;
import com.cjr.cjrimagestorage.exception.BusinessException;
import com.cjr.cjrimagestorage.exception.ErrorCode;
import com.cjr.cjrimagestorage.exception.ThrowUtils;
import com.cjr.cjrimagestorage.model.dto.space.SpaceLevel;
import com.cjr.cjrimagestorage.model.dto.space.SpaceQueryRequest;
import com.cjr.cjrimagestorage.model.dto.space.SpaceUpdateRequest;
import com.cjr.cjrimagestorage.model.entity.Space;
import com.cjr.cjrimagestorage.model.enums.SpaceLevelEnum;
import com.cjr.cjrimagestorage.service.SpaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/space")
public class SpaceController {

    @Resource
    private SpaceService spaceService;

    @PostMapping("/update")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Boolean> updateSpace(@RequestBody SpaceUpdateRequest spaceUpdateRequest) {
        if (spaceUpdateRequest == null || spaceUpdateRequest.getId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 将实体类和 DTO 进行转换
        Space space = new Space();
        BeanUtils.copyProperties(spaceUpdateRequest, space);
        // 自动填充数据
        spaceService.fillSpaceBySpaceLevel(space);
        // 数据校验
        spaceService.validSpace(space, false);
        // 判断是否存在
        long id = spaceUpdateRequest.getId();
        Space oldSpace = spaceService.getById(id);
        ThrowUtils.throwIf(oldSpace == null, ErrorCode.NOT_FOUND_ERROR);
        // 操作数据库
        boolean result = spaceService.updateById(space);
        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
        return ResultUtils.success(true);
    }

    /**
     * 获取空间级别列表，便于前端展示
     *
     * @return
     */
    @GetMapping("/list/level")
    public BaseResponse<List<SpaceLevel>> listSpaceLevel() {
        List<SpaceLevel> spaceLevelList = Arrays.stream(SpaceLevelEnum.values())
                .map(spaceLevelEnum -> new SpaceLevel(
                        spaceLevelEnum.getValue(),
                        spaceLevelEnum.getText(),
                        spaceLevelEnum.getMaxCount(),
                        spaceLevelEnum.getMaxSize()
                ))
                .collect(Collectors.toList());
        return ResultUtils.success(spaceLevelList);
    }


}
