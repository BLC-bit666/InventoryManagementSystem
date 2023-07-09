package com.xpu.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @BelongsProject: InventoryManagementSystem
 * @BelongsPackage: com.xpu.config
 * @Author: BLC
 * @CreateTime: 2023-07-06  15:54
 * @Description: TODO
 * @Version: 1.0
 */
@Configuration
public class MybatisPlusConfig {
    /**
     * @description: 创建MybatisPlus拦截器，为其添加分页拦截器
     * @param: []
     * @return: com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor
     * @author: BLC
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return mybatisPlusInterceptor;
    }
}