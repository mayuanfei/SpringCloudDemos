package com.laoma.ordercenter.config;

import RibbonConfiguration.RibbonConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Configuration;

/**
 * @program: SpringCloudDemos
 * @description: 调用用户中心采用随机算法
 * @author: 老马
 * @create: 2021-06-29 14:32
 **/
@Configuration
@RibbonClients(defaultConfiguration = RibbonConfiguration.class)
public class UserCenterRibbonConfiguration {

}
