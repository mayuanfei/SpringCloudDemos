package com.laoma.usercenter.controller;

import com.laoma.usercenter.dto.response.UserInfoResponse;
import com.laoma.usercenter.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: SpringCloudDemos
 * @description:
 * @author: 老马
 * @create: 2021-06-16 09:08
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/{wxid}/info.json")
    public UserInfoResponse getUserInfo(@PathVariable String wxid) {
         return this.userService.getUserInfoByWxId(wxid);
    }

}
