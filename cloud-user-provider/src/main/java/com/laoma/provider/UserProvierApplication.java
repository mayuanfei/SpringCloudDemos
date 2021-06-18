package com.laoma.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @program: SpringCloudDemos
 * @description:
 * @author: 老马
 * @create: 2021-06-16 08:55
 **/
@MapperScan(basePackages = "com.laoma.provider.dao.mapper")
@SpringBootApplication
@EnableDiscoveryClient
public class UserProvierApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserProvierApplication.class, args);
    }
}
