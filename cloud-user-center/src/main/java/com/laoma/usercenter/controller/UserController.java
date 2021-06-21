package com.laoma.usercenter.controller;

import com.laoma.usercenter.common.CommonResponse;
import com.laoma.usercenter.dto.request.UserInfoAppendRequest;
import com.laoma.usercenter.dto.response.UserInfoResponse;
import com.laoma.usercenter.service.UserService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}/info.json")
    public UserInfoResponse getUserInfo(@PathVariable Integer id) {
         return this.userService.getUserInfoById(id);
    }

    @PostMapping("/append.json")
    public CommonResponse appendUserInfo(UserInfoAppendRequest request) throws Exception {
        return this.userService.appendUserInfo(request);
    }
}
