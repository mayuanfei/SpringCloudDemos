package com.laoma.ordercenter.config;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: employee
 * @description:
 * @author: 老马
 * @create: 2018-07-11 09:18
 **/
@Configuration
public class FastJsonHttpConverterConfiguration {

    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters(){
        //1.需要定义一个convert转换消息的对象;
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        //2:添加fastJson的配置信息;
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //是否输出值为null的字段,默认为false
        //fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteMapNullValue);
        //设置全局的日期格式
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
        //设置驼峰转换
//        ParserConfig parserConfig = ParserConfig.getGlobalInstance();
//        parserConfig.propertyNamingStrategy = PropertyNamingStrategy.SnakeCase;
//        fastJsonConfig.setParserConfig(parserConfig);
        //3处理中文乱码问题
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON);
        //4.在convert中添加配置信息.
        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        HttpMessageConverter<?> converter = fastJsonHttpMessageConverter;
        return new HttpMessageConverters(converter);
    }
}
