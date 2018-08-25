package com.quinn.asm.sample1;


import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.util.ASMifier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyClass {

    public static void main(String[] args) {
//        CopyClass copyClass = new CopyClass();
//        copyClass.call("/Users/quinn/Documents/workspaces/asmnote/out/production/classes/com/quinn/asm/sample1/CopyClass.class",
//                PathUtils.getResourcesPath() + File.separator + "class" + File.separator + "CopyClass2.class");
        String[] params = {"/Users/quinn/Documents/workspaces/asmnote/out/production/classes/com/quinn/asm/sample1/CopyClass.class"};
        try {
            ASMifier.main(params);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void copy(String inputPath, String outputPath) {
        try {
            FileInputStream is = new FileInputStream(inputPath);

            ClassReader cr = new ClassReader(is);
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
            cr.accept(cw, 0);

            FileOutputStream fos = new FileOutputStream(outputPath);
            fos.write(cw.toByteArray());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
