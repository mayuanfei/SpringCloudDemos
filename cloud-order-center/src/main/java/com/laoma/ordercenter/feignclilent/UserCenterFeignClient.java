package com.laoma.ordercenter.feignclilent;

import com.laoma.ordercenter.dto.request.UserInfoSearchRequest;
import com.laoma.ordercenter.dto.response.UserInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @program: SpringCloudDemos
 * @description: 调用用户中心微服务的Feign接口
 * @author: 老马
 * @create: 2021-06-23 15:18
 **/
//@FeignClient(name = "${service.nacos-user-service}", configuration = FeignConfiguration.class)
@FeignClient(name = "${service.nacos-user-service}")
public interface UserCenterFeignClient {
    /***
    * Feign会构造出url：
     * http://user-center/usercenter/user/{wxid}/info.json
    */
    @GetMapping("/usercenter/user/{wxid}/info.json")
    UserInfoResponse findUserByWxid(@PathVariable("wxid") String wxid);

    @GetMapping("/usercenter/user/list1.json")
    UserInfoResponse findUser1(@SpringQueryMap UserInfoSearchRequest  userInfoSearch);

    @GetMapping("/usercenter/user/{wxid}/list2.json")
    UserInfoResponse findUser2(@PathVariable("wxid") String wxid,
                               @RequestParam("id") Integer id,
                               @RequestParam("wxNickname") String wxNickname);

    @GetMapping("/usercenter/user/list3.json")
    UserInfoResponse findUser3(@RequestParam Map<String, Object> map);


    @PostMapping("/usercenter/user/postlist1.json")
    UserInfoResponse postFindUser1(@RequestBody UserInfoSearchRequest  search);

    @PostMapping("/usercenter/user/postlist2.json")
    UserInfoResponse postFindUser2(@SpringQueryMap UserInfoSearchRequest  search);
}

