package com.laoma.usercenter.service;

import com.laoma.usercenter.dto.request.UserInfoSearchRequest;
import com.laoma.usercenter.dto.response.UserInfoResponse;

/**
 * @program: SpringCloudDemos
 * @description:
 * @author: 老马
 * @create: 2021-06-21 14:32
 **/
public interface UserService {

    /**
    * @Description:通过id获得用户信息
    * @param: id
    * @return: com.laoma.provider.dao.pojo.UserInfo
    * @author: 老马
    * @Date: 2021/6/21 14:33
    */
    UserInfoResponse getUserInfoByWxId(String id);
    
    /** 
    * @Description: 通过请求参数进行查询
    * @param: request
    * @return: com.laoma.usercenter.dto.response.UserInfoResponse
    * @author: 老马
    * @Date: 2021/11/11 17:17
    */ 
    UserInfoResponse getUserInfos(UserInfoSearchRequest request);

}

