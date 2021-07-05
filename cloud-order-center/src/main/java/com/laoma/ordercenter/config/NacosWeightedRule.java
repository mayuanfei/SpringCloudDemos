package com.laoma.ordercenter.config;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.NacosServiceManager;
import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.Server;

import javax.annotation.Resource;

/**
 * @program: SpringCloudDemos
 * @description: 支持nacos的权重
 * @author: 老马
 * @create: 2021-06-29 16:07
 **/
public class NacosWeightedRule extends AbstractLoadBalancerRule {

    @Resource
    private NacosDiscoveryProperties nacosDiscoveryProperties;
    @Resource
    private NacosServiceManager nacosServiceManager;

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {
        //读取配置文件，并初始化NacosWeightedRule
    }
    @Override
    public Server choose(Object o) {
        BaseLoadBalancer loadBalancer = (BaseLoadBalancer) this.getLoadBalancer();
        //获取想要请求的服务名称
        String name = loadBalancer.getName();
        //拿到服务发现的相关api
        NamingService namingService = this.nacosServiceManager.getNamingService(nacosDiscoveryProperties.getNacosProperties());

        Instance instance = null;
        try {
            //nacos client自动通过基于权重的负载均衡算法，返回一个实例
            instance = namingService.selectOneHealthyInstance(name);
        } catch (NacosException e) {
            e.printStackTrace();
        }
        return new NacosServer(instance);
    }
}
