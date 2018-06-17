package com.wk51920.common.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * @program: FileNumMonitor
 * @description: 读取系统配置文件的工具类
 * @author: wk
 * @create: 2018-06-17 21:54
 **/
@Component
public class PropTool {
    private static Properties prop;
    private static Logger logger = LoggerFactory.getLogger(PropTool.class);


    static {
        String basePath = System.getProperty("user.dir");
        String appConfigPath = basePath + "/config/appConfig.properties";
        File configFile = new File(appConfigPath);

        if(!configFile.isFile()){
            logger.error("appConfig file path error.....");
            System.exit(-1);
        }

        prop = new Properties();

        try {
            prop.load(new FileInputStream(configFile));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String getProp(String key) {
        return prop.getProperty(key);
    }

}
