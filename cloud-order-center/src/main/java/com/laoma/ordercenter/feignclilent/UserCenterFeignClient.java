package com.laoma.ordercenter.feignclilent;

import com.laoma.ordercenter.dto.response.UserInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: SpringCloudDemos
 * @description: 调用用户中心微服务的Feign接口
 * @author: 老马
 * @create: 2021-06-23 15:18
 **/
@FeignClient(name = "${service.nacos-user-service}")
public interface UserCenterFeignClient {

    /***
    * Feign会构造出url：
     * http://user-center/usercenter/user/{wxid}/info.json
    */
    @GetMapping("/usercenter/user/{wxid}/info.json")
    UserInfoResponse findUserByWxid(@PathVariable("wxid") String wxid);
}

