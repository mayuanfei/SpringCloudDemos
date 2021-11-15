package com.laoma.ordercenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @program: SpringCloudDemos
 * @description:
 * @author: 老马
 * @create: 2021-06-16 08:55
 **/
@MapperScan(basePackages = "com.laoma.ordercenter.dao.mapper")
@SpringBootApplication
//@EnableFeignClients(defaultConfiguration = FeignConfiguration.class)
@EnableFeignClients
public class OrderCenterApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(OrderCenterApplication.class, args);
    }
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
