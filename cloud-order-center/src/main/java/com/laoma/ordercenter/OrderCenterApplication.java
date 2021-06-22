package com.laoma.ordercenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @program: SpringCloudDemos
 * @description:
 * @author: 老马
 * @create: 2021-06-16 08:55
 **/
@MapperScan(basePackages = "com.laoma.ordercenter.dao.mapper")
@SpringBootApplication
public class OrderCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderCenterApplication.class, args);
    }

}
