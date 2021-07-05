package RibbonConfiguration;

import com.laoma.ordercenter.config.NacosSameClusterWeightedRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: SpringCloudDemos
 * @description: 全局设置ribbon的负载均衡规则
 * @author: 老马
 * @create: 2021-06-29 14:35
 **/
@Configuration
public class RibbonConfiguration {
    @Bean
    public IRule ribbonRule() {
        return new NacosSameClusterWeightedRule();
    }
}
