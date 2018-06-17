package com.wk51920.services.fileCounterService;

import java.util.Map;

/**
 * @program: FileNumMonitor
 * @description: 文件个数计数器接口
 * @author: wk
 * @create: 2018-06-17 19:06
 **/
public interface FileCounter {
    Map<String, Long> getFilesCount();
}
