package com.xpu.config;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @BelongsProject: InventoryManagementSystem
 * @BelongsPackage: com.xpu.config
 * @Author: BLC
 * @CreateTime: 2023-07-07  19:17
 * @Description: 解决java.lang.IllegalArgumentException:Invalid character found in the request 异常
 * @Version: 1.0
 */
@Configuration
public class TomCatConfig {
    @Bean
    public TomcatServletWebServerFactory webServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.addConnectorCustomizers((Connector connector) -> {
            connector.setProperty("relaxedPathChars", "\"<>[\\]^`{|}");
            connector.setProperty("relaxedQueryChars", "\"<>[\\]^`{|}");
        });
        return factory;
    }
}

