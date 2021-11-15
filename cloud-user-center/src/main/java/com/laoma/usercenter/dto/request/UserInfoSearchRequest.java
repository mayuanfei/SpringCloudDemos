package com.laoma.usercenter.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: SpringCloudDemos
 * @description: 用户查询dto
 * @author: 老马
 * @create: 2021-11-11 17:12
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoSearchRequest {
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
}
