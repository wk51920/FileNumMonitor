package com.wk51920.services.fileCounterService.impl;

import com.wk51920.common.tools.PropTool;
import com.wk51920.services.fileCounterService.FileCounter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * @program: FileNumMonitor
 * @description: 文件计数器基础实现类
 * @author: wk
 * @create: 2018-06-17 19:08
 **/
@Component
public class BaseFileCounterImpl implements FileCounter {
    private Logger logger = LoggerFactory.getLogger(BaseFileCounterImpl.class);

    /**
     * 统计给定目录下文件的个数
     *
     * @param dirPath
     * @return
     */
    private long getFileCount(String dirPath) {
        long fileCounter = 0;
        try {
            fileCounter = Files.list(Paths.get(dirPath)).count();
        } catch (IOException e) {
            logger.error("##{}## list files failed......", dirPath);
            logger.error("failed reason is {}", e.getMessage());
            e.printStackTrace();
        }
        return fileCounter;
    }


    private boolean isAllDirs(String[] dirPathArray){
        for (String dirPath : dirPathArray) {
            if (!new File(dirPath).isDirectory()) {
                logger.error("{} is not dir.....");
                return false;
            }
        }
        return true;
    }

    /**
     * 得到监控目录列表
     *
     * @return
     */
    private List<String> getDirPaths(String dirPaths) {
        String[] dirPathArray = dirPaths.split(",");

        if(!isAllDirs(dirPathArray)){
            return null;
        }

        return Arrays.asList(dirPathArray);
    }

    /**
     * 统计各个目录列表的文件个数
     *
     * @return
     */
    @Override
    public Map<String, Long> getFilesCount() {
        List<String> dirList = getDirPaths(PropTool.getProp("dirPaths"));

        if (null == dirList) {
            logger.error("dirList is null, something wrong...");
            return null;
        }

        Map<String, Long> dirFileNum = new HashMap<>();

        for(String dirPath : dirList){
            long fileNum = getFileCount(dirPath);
            dirFileNum.put(dirPath, fileNum);
        }

        return dirFileNum;
    }
}
