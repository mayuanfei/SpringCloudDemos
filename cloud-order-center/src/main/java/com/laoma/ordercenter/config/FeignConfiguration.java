package com.laoma.ordercenter.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @program: SpringCloudDemos
 * @description: 配置Feign
 * @author: 老马
 * @create: 2021-11-08 16:59
 **/
//不要写@Configuration,否则要移动位置，不能被启动类所以在包扫码到
//否则会受到父子上下文的影响
public class FeignConfiguration {

    //设置打印级别
    @Bean
    public Logger.Level level() {
        //让Feign打印所有请求的信息
        return Logger.Level.FULL;
    }
}
