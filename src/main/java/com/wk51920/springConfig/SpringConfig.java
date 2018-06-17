package com.wk51920.springConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

/**
 * @program: FileNumMonitor
 * @description: Spring的Java配置类
 * @author: wk
 * @create: 2018-06-17 19:04
 **/
@Configuration
@ImportResource("classpath:applicationContext.xml")
@ComponentScan(basePackages = {"com.wk51920"})
@PropertySources({
        @PropertySource(value="file:${user.dir}/config/appConfig.properties", ignoreResourceNotFound = true)
})
public class SpringConfig {
    @Autowired
    Environment env;

   @Bean
   public static PropertySourcesPlaceholderConfigurer placeholderConfigurer(){
       return new PropertySourcesPlaceholderConfigurer();
   }
}
