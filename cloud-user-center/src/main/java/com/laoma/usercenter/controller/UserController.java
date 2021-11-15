package com.laoma.usercenter.controller;

import com.laoma.usercenter.dto.request.UserInfoSearchRequest;
import com.laoma.usercenter.dto.response.UserInfoResponse;
import com.laoma.usercenter.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/list1.json")
    public UserInfoResponse getUserInfos1(UserInfoSearchRequest request) {
        return this.userService.getUserInfos(request);
    }

    @GetMapping("/{wxid}/list2.json")
    public UserInfoResponse getUserInfos2(@PathVariable String wxid, Integer id, String wxNickname) {
        UserInfoSearchRequest request = UserInfoSearchRequest.builder().wxNickname(wxNickname).wxId(wxid).id(id).build();
        return this.userService.getUserInfos(request);
    }

    @GetMapping("/list3.json")
    public UserInfoResponse getUserInfos3(String wxid, String wxNickname) {
        UserInfoSearchRequest request = new UserInfoSearchRequest();
        request.setWxId(wxid);
        request.setWxNickname(wxNickname);
        return this.userService.getUserInfos(request);
    }



    //采用json格式
    @PostMapping("/postlist1.json")
    public UserInfoResponse postUserInfos1(@RequestBody UserInfoSearchRequest request) {
        return this.userService.getUserInfos(request);
    }


    //采用form表单形式
    @PostMapping("/postlist2.json")
    public UserInfoResponse postUserInfos2(UserInfoSearchRequest request) {
        return this.userService.getUserInfos(request);
    }



}
