package com.quinn.asm.common;

import java.io.File;

public class PathUtils {

    public static String getResourcesPath() {
        String workingDir = System.getProperty("user.dir");
        return workingDir + File.separator + "src/main/resources";
    }

    public static String getGenerateClassPath(String name){
        return getResourcesPath() + File.separator + "class" + File.separator + name;
    }
}
