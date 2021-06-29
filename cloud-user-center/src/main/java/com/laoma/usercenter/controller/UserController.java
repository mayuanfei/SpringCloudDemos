package com.laoma.usercenter.controller;

import com.laoma.usercenter.dto.response.UserInfoResponse;
import com.laoma.usercenter.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: SpringCloudDemos
 * @description:
 * @author: 老马
 * @create: 2021-06-16 09:08
 **/
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/{wxid}/info.json")
    public UserInfoResponse getUserInfo(HttpServletRequest request,  @PathVariable String wxid) {
        log.info("请求到端口: {}", request.getRemotePort());
        return this.userService.getUserInfoByWxId(wxid);
    }

}
