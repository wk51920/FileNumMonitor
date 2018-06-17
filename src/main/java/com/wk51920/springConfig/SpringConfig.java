package com.wk51920.springConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @program: FileNumMonitor
 * @description: Spring的Java配置类
 * @author: wk
 * @create: 2018-06-17 19:04
 **/
@Configuration
@ImportResource("classpath:applicationContext.xml")
@ComponentScan(basePackages = {"com.wk51920"})
public class SpringConfig {
}
