package com.laoma.usercenter.dto.request;

import lombok.Data;

/**
 * @program: SpringCloudDemos
 * @description: 添加用户信息
 * @author: 老马
 * @create: 2021-06-21 15:57
 **/
@Data
public class UserInfoAppendRequest {

    /**
     * 微信id
     */
    private String wxId;

    /**
     * 微信昵称
     */
    private String wxNickname;

    /**
     * 头像
     */
    private String avatarUrl;

    /**
     * 积分
     */
    private Integer bonus;

}
