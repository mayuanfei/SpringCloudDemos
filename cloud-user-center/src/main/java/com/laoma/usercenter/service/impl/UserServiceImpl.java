package com.laoma.usercenter.service.impl;

import com.alibaba.fastjson.JSON;
import com.laoma.usercenter.dao.entity.UserInfo;
import com.laoma.usercenter.dao.mapper.UserInfoMapper;
import com.laoma.usercenter.dto.request.UserInfoSearchRequest;
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
     * @Description:通过id获得用户信息
     * @param: id
     * @return: com.laoma.provider.dao.pojo.UserInfo
     * @author: 老马
     * @Date: 2021/6/21 14:33
     */
    @Override
    public UserInfoResponse getUserInfoByWxId(String wxid) {
        //通过微信id进行查询
        UserInfo userInfo = this.userInfoMapper.selectUserInfoByWxId(wxid);
        if(userInfo == null) {
            return null;
        }
        //转换成dto对象
        UserInfoResponse userInfoResp = JSON.parseObject(JSON.toJSONString(userInfo), UserInfoResponse.class);
        return userInfoResp;
    }

    /**
     * @param request
     * @Description: 通过请求参数进行查询
     * @param: request
     * @return: com.laoma.usercenter.dto.response.UserInfoResponse
     * @author: 老马
     * @Date: 2021/11/11 17:17
     */
    @Override
    public UserInfoResponse getUserInfos(UserInfoSearchRequest request) {
        return this.userInfoMapper.selectUserInfoByCondition(request);
    }
}
