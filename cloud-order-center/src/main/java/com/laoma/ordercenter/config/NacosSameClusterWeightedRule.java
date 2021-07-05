package com.laoma.ordercenter.config;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.NacosServiceManager;
import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.alibaba.nacos.client.naming.core.Balancer;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: SpringCloudDemos
 * @description: 支持nacos的权重并且同一集群优先调用
 * @author: 老马
 * @create: 2021-07-02 15:39
 **/
@Slf4j
public class NacosSameClusterWeightedRule extends AbstractLoadBalancerRule {
    @Resource
    private NacosDiscoveryProperties nacosDiscoveryProperties;
    @Resource
    private NacosServiceManager nacosServiceManager;

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object o) {
        try {
            //拿到配置文件中的名称。比如：BJ
            String clusterName = nacosDiscoveryProperties.getClusterName();
            //获得负载均衡器
            BaseLoadBalancer loadBalancer = (BaseLoadBalancer) this.getLoadBalancer();
            //想要请求的微服务名称
            String serviceName = loadBalancer.getName();
            //拿到服务发现的相关api
            NamingService namingService = this.nacosServiceManager.getNamingService(nacosDiscoveryProperties.getNacosProperties());
            //找到指定服务下所有健康的实例
            List<Instance> instances = namingService.selectInstances(serviceName, true);
            //过滤出相同集群下的所有实例
            List<Instance> sameClusterInstances = instances.stream().filter(instance -> {
                return instance.getClusterName().equals(clusterName);
            }).collect(Collectors.toList());
            //优先调用同集群下的实例，如果为空的话，那么调用其他集群实例
            List<Instance> chosenClusterInstances = new ArrayList<>();
            if(CollectionUtils.isEmpty(sameClusterInstances)) {
                chosenClusterInstances = instances;
                log.warn("发生了跨集群调用：name={}, clusterName={}", serviceName, clusterName);
            }else {
                chosenClusterInstances = sameClusterInstances;
            }
            //通过基于权重的负载均衡算法，返回一个实例
            Instance instance = MyNacosBalancer.getHostByRandomWeight(chosenClusterInstances);
            log.info("选择的实例：instance={}", instance);
            return new NacosServer(instance);
        }catch (Exception e) {
            log.error("获得nacos服务实例时出错", e);
            return null;
        }
    }


}

//自定义内部类，为了调用Nacos中Balancer类中的protected方法getHostByRandomWeight获得实例
class MyNacosBalancer extends Balancer {
    public static Instance getHostByRandomWeight(List<Instance> hosts) {
        return Balancer.getHostByRandomWeight(hosts);
    }
}
