package com.laoma.usercenter.service.impl;

import com.alibaba.fastjson.JSON;
import com.laoma.usercenter.common.CommonResponse;
import com.laoma.usercenter.dao.entity.UserInfo;
import com.laoma.usercenter.dao.mapper.UserInfoMapper;
import com.laoma.usercenter.dto.request.UserInfoAppendRequest;
import com.laoma.usercenter.dto.response.UserInfoResponse;
import com.laoma.usercenter.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: SpringCloudDemos
 * @description: 用户服务类实现
 * @author: 老马
 * @create: 2021-06-21 14:33
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserInfoMapper userInfoMapper;

    /**
     * @param id
     * @Description:通过id获得用户信息
     * @param: id
     * @return: com.laoma.provider.dao.pojo.UserInfo
     * @author: 老马
     * @Date: 2021/6/21 14:33
     */
    @Override
    public UserInfoResponse getUserInfoById(Integer id) {
        UserInfo userInfo = this.userInfoMapper.selectByPrimaryKey(id);
        //转换成dto对象
        UserInfoResponse userInfoResp = JSON.parseObject(JSON.toJSONString(userInfo), UserInfoResponse.class);
        return userInfoResp;
    }

    @Override
    public CommonResponse appendUserInfo(UserInfoAppendRequest request) throws Exception {
        //把dto对象转换为数据库对象
        UserInfo userInfo = JSON.parseObject(JSON.toJSONString(request), UserInfo.class);
        this.userInfoMapper.insertSelective(userInfo);
        return CommonResponse.buildSuccessCommonResponse();
    }
}
