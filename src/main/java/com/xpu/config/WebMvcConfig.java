package com.xpu.config;

import com.xpu.common.JacksonObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * @BelongsProject: InventoryManagementSystem
 * @BelongsPackage: com.xpu.config
 * @Author: BLC
 * @CreateTime: 2023-07-06  15:52
 * @Description: TODO
 * @Version: 1.0
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    /**
     * @description: 设置静态资源映射
     * @param: [registry]
     * @return: void
     * @author: BLC
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/backend/**").addResourceLocations("classpath:/backend/");
    }

    /**
     * @description: 扩展mvc框架的消息转换器
     * @param: [converters]
     * @return: void
     * @author: BLC
     */
    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        //创建消息转换器对象
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        //设置转换器对象，底层是使用jackson将java对象转换为json
        messageConverter.setObjectMapper(new JacksonObjectMapper());
        //将上面的消息转换器对象追加到mvc框架的转换器集合中,0为优先使用
        converters.add(0,messageConverter);
    }
}