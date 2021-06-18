package com.laoma.provider.test;

import cn.hutool.core.lang.UUID;
import com.laoma.provider.dao.mapper.OrderMasterMapper;
import com.laoma.provider.dao.pojo.OrderMaster;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @program: SpringCloudDemos
 * @description:
 * @author: 老马
 * @create: 2021-06-17 11:14
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTest {
    @Resource
    private OrderMasterMapper masterMapper;

    @Test
    public void testOrderMaster() {
        OrderMaster orderMaster = OrderMaster.builder()
                .orderId(UUID.fastUUID().toString(true))
                .buyerName("老马")
                .buyerPhone("13141458088")
                .orderAmount(new BigDecimal("12.35"))
                .build();
        this.masterMapper.insertSelective(orderMaster);
    }
}
