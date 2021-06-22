package com.laoma.usercenter.dto.response;

import lombok.Data;

/**
 * @program: SpringCloudDemos
 * @description:
 * @author: 老马
 * @create: 2021-06-21 15:06
 **/
@Data
public class UserInfoResponse {
    /**
     * 唯一索引
     */
    private Integer id;

    /**
     * 微信id
     */
    private String wxId;

    /**
     * 微信昵称
     */
    private String wxNickname;

    /**
     * 积分
     */
    private Integer bonus;

    //头像
    private String avatarUrl;

}
