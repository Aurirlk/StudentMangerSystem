package com.rabbiter.sms.utils;

import java.io.File;

public class ResourceUtil {
    public static String getPath() {
        String staticDir;
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith("win")) {  //windows系统

            staticDir = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files\\";
            // 如果结果目录不存在，则创建目录
            File resDirFile = new File(staticDir);
            if (!resDirFile.exists()) {
                boolean flag = resDirFile.mkdirs();
                if (!flag) throw new RuntimeException("创建结果目录失败");
            }
        } else {
            //linux系统
            staticDir = "/usr/local/my_project/files/";
            // 如果结果目录不存在，则创建目录
            File resDirFile = new File(staticDir);
            if (!resDirFile.exists()) {
                boolean flag = resDirFile.mkdirs();
                if (!flag) throw new RuntimeException("创建结果目录失败");
            }
        }
        return staticDir;

    }
}
