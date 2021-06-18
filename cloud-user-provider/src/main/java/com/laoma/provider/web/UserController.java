package com.laoma.provider.web;

import org.springframework.web.bind.annotation.*;

/**
 * @program: SpringCloudDemos
 * @description:
 * @author: 老马
 * @create: 2021-06-16 09:08
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/{id}/info")
    public String getUserInfo(@PathVariable String id) {
        return id;
    }
}
