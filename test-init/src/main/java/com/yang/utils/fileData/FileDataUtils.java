package com.yang.utils.fileData;

import java.io.InputStream;

/**
 * @Author: yang
 * @Date: 2020-08-01 22:33
 * @Description: 文件操作
 */
public class FileDataUtils {
    public static void main(String[] args) {
        System.out.println("获得resource下面的文件路径" + getResourcePath());
    }

    // 获得resource下面的文件路径
    public static String getResourcePath() {
        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "template";
        return path;
    }
    // 文件路径
    public static String getPath() {
        return "/Users/yangzhibin/Desktop/0301learn/java-learn/test-init";
    }

}
