package com.quinn.asm.sample2;

import com.quinn.asm.common.PathUtils;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 每个方法被调用之前和之后打印一句话
 */
public class ByteCodeWeaver {

    public static void main(String[] args) {
<<<<<<< HEAD
        String inputFile = PathUtils.getTestClassPath("Demo.class");
        String outputFile = PathUtils.getTestClassPath("DemoResult.class");
=======
        String inputFile = PathUtils.getWorkspacePath() + File.separator + "out/production/classes/com/quinn/asm/sample2/MethodCall.class";
        String outputFile = PathUtils.getGenerateClassPath("MethodCall.class");
>>>>>>> c6c93b2c6ce590fb98d9f12852932aec3fb2bfd6
        run(inputFile, outputFile);
    }

    private static void run(String inputPath, String outputPath) {
        try {
            FileInputStream is = new FileInputStream(inputPath);

            ClassReader cr = new ClassReader(is);
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
            ClassAdapter adapter = new ClassAdapter(cw);
            cr.accept(adapter, ClassReader.EXPAND_FRAMES);
            //SKIP_DEBUG  - crash
            //SKIP_CODE   - 方法全空
            //SKIP_FRAMES   - OK
            //EXPAND_FRAMES   - OK

            FileOutputStream fos = new FileOutputStream(outputPath);
            fos.write(cw.toByteArray());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
