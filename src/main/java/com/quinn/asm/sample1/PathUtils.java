package com.quinn.asm.sample1;

import java.io.File;

public class PathUtils {

    public static String getResourcesPath() {
        String workingDir = System.getProperty("user.dir");
        return workingDir + File.separator + "src/main/resources";
    }
}
