package com.quinn.asm.generate;
import java.io.File;
import java.util.*;

import com.quinn.asm.common.PathUtils;
import org.apache.commons.io.FileUtils;
import org.objectweb.asm.*;
public class Gen {

    public static void main(String[] args) {
        try {
            String outputFile = PathUtils.getGenerateClassPath("dump.class");
            File file= new File(outputFile);
            file.createNewFile();
            FileUtils.writeByteArrayToFile(file, dump());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] dump() throws Exception {

        ClassWriter cw = new ClassWriter(0);
        FieldVisitor fv;
        MethodVisitor mv;
        AnnotationVisitor av0;

        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC + Opcodes.ACC_SUPER, "com/quinn/asm/sample2/target/MethodCallTiming", null, "java/lang/Object", null);

        cw.visitSource("MethodCallTiming.java", null);

        {
            mv = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLineNumber(3, l0);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
            mv.visitInsn(Opcodes.RETURN);
            Label l1 = new Label();
            mv.visitLabel(l1);
            mv.visitLocalVariable("this", "Lcom/quinn/asm/sample2/target/MethodCallTiming;", null, l0, l1, 0);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLineNumber(6, l0);
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
            mv.visitVarInsn(Opcodes.LSTORE, 1);
            Label l1 = new Label();
            mv.visitLabel(l1);
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "com/quinn/asm/sample2/target/MethodCallTiming", "printOne", "()V", false);
            Label l2 = new Label();
            mv.visitLabel(l2);
            mv.visitLineNumber(7, l2);
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "com/quinn/asm/sample2/target/MethodCallTiming", "printTwo", "()V", false);
            Label l3 = new Label();
            mv.visitLabel(l3);
            mv.visitLineNumber(8, l3);
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "com/quinn/asm/sample2/target/MethodCallTiming", "printTwo", "()V", false);
            Label l4 = new Label();
            mv.visitLabel(l4);
            mv.visitLineNumber(9, l4);
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
            mv.visitVarInsn(Opcodes.LLOAD, 1);
            mv.visitInsn(Opcodes.LSUB);
            mv.visitVarInsn(Opcodes.LSTORE, 3);
            Label l5 = new Label();
            mv.visitLabel(l5);
            mv.visitInsn(Opcodes.RETURN);
            Label l6 = new Label();
            mv.visitLabel(l6);
            mv.visitLocalVariable("args", "[Ljava/lang/String;", null, l0, l6, 0);
            mv.visitLocalVariable("start", "J", null, l1, l6, 1);
            mv.visitLocalVariable("ellapse", "J", null, l5, l6, 3);
            mv.visitMaxs(4, 5);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(Opcodes.ACC_PRIVATE + Opcodes.ACC_STATIC, "printOne", "()V", null, null);
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLineNumber(12, l0);
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
            mv.visitVarInsn(Opcodes.LSTORE, 0);
            Label l1 = new Label();
            mv.visitLabel(l1);
            mv.visitLineNumber(13, l1);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn("Hello World");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            Label l2 = new Label();
            mv.visitLabel(l2);
            mv.visitLineNumber(14, l2);
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
            mv.visitVarInsn(Opcodes.LLOAD, 0);
            mv.visitInsn(Opcodes.LSUB);
            mv.visitVarInsn(Opcodes.LSTORE, 2);
            Label l3 = new Label();
            mv.visitLabel(l3);
            mv.visitInsn(Opcodes.RETURN);
            Label l4 = new Label();
            mv.visitLabel(l4);
            mv.visitLocalVariable("start", "J", null, l1, l4, 0);
            mv.visitLocalVariable("ellapse", "J", null, l3, l4, 2);
            mv.visitMaxs(4, 4);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(Opcodes.ACC_PRIVATE + Opcodes.ACC_STATIC, "printTwo", "()V", null, null);
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLineNumber(17, l0);
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
            mv.visitVarInsn(Opcodes.LSTORE, 0);
            Label l1 = new Label();
            mv.visitLabel(l1);
            mv.visitLineNumber(18, l1);
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "com/quinn/asm/sample2/target/MethodCallTiming", "printOne", "()V", false);
            Label l2 = new Label();
            mv.visitLabel(l2);
            mv.visitLineNumber(19, l2);
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "com/quinn/asm/sample2/target/MethodCallTiming", "printOne", "()V", false);
            Label l3 = new Label();
            mv.visitLabel(l3);
            mv.visitLineNumber(20, l3);
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
            mv.visitVarInsn(Opcodes.LLOAD, 0);
            mv.visitInsn(Opcodes.LSUB);
            mv.visitVarInsn(Opcodes.LSTORE, 2);
            Label l4 = new Label();
            mv.visitLabel(l4);
            mv.visitInsn(Opcodes.RETURN);
            Label l5 = new Label();
            mv.visitLabel(l5);
            mv.visitLocalVariable("start", "J", null, l1, l5, 0);
            mv.visitLocalVariable("ellapse", "J", null, l4, l5, 2);
            mv.visitMaxs(4, 4);
            mv.visitEnd();
        }
        cw.visitEnd();

        return cw.toByteArray();
    }
}






