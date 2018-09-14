package com.quinn.asm.asmfier;

import com.quinn.asm.common.PathUtils;
import org.apache.commons.io.FileUtils;
import org.objectweb.asm.*;

import java.io.File;

public class DumpTool implements Opcodes {

    public static void main(String[] args) {
        try {
            byte[] bytes = dump();
            File file = new File(PathUtils.getTestClassPath("MethodCall.class"));
            file.createNewFile();
            FileUtils.writeByteArrayToFile(file, bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] dump() throws Exception {

        ClassWriter cw = new ClassWriter(0);
        FieldVisitor fv;
        MethodVisitor mv;
        AnnotationVisitor av0;

        cw.visit(52, ACC_PUBLIC + ACC_SUPER, "com/quinn/asm/sample2/MethodCall", null, "java/lang/Object", null);

        cw.visitSource("MethodCall.java", null);

        {
            mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLineNumber(3, l0);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
            mv.visitInsn(RETURN);
            Label l1 = new Label();
            mv.visitLabel(l1);
            mv.visitLocalVariable("this", "Lcom/quinn/asm/sample2/MethodCall;", null, l0, l1, 0);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLineNumber(6, l0);
            mv.visitMethodInsn(INVOKESTATIC, "com/quinn/asm/sample2/MethodCall", "printOne", "()V", false);
            mv.visitMethodInsn(INVOKESTATIC, "com/quinn/asm/sample2/MethodCall", "printOne", "()V", false);
            mv.visitMethodInsn(INVOKESTATIC, "com/quinn/asm/sample2/MethodCall", "printTwo", "()V", false);
            Label l1 = new Label();
            mv.visitLabel(l1);
            mv.visitLineNumber(7, l1);
            mv.visitInsn(RETURN);
            Label l2 = new Label();
            mv.visitLabel(l2);
            mv.visitLocalVariable("args", "[Ljava/lang/String;", null, l0, l2, 0);
            mv.visitMaxs(0, 1);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PRIVATE + ACC_STATIC, "printOne", "()V", null, null);
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLineNumber(10, l0);
            mv.visitInsn(ICONST_5);
            mv.visitInsn(ICONST_0);
            mv.visitInsn(IDIV);
            mv.visitVarInsn(ISTORE, 0);
            Label l1 = new Label();
            mv.visitLabel(l1);
            mv.visitLineNumber(11, l1);
            mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn("Hello World");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            Label l2 = new Label();
            mv.visitLabel(l2);
            mv.visitLineNumber(12, l2);
            mv.visitInsn(RETURN);
            Label l3 = new Label();
            mv.visitLabel(l3);
            mv.visitLocalVariable("a", "I", null, l1, l3, 0);
            mv.visitMaxs(2, 1);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PRIVATE + ACC_STATIC, "printTwo", "()V", null, null);
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLineNumber(15, l0);
            mv.visitMethodInsn(INVOKESTATIC, "com/quinn/asm/sample2/MethodCall", "printOne", "()V", false);
            Label l1 = new Label();
            mv.visitLabel(l1);
            mv.visitLineNumber(16, l1);
            mv.visitMethodInsn(INVOKESTATIC, "com/quinn/asm/sample2/MethodCall", "printOne", "()V", false);
            Label l2 = new Label();
            mv.visitLabel(l2);
            mv.visitLineNumber(17, l2);
            mv.visitInsn(RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }
        cw.visitEnd();

        return cw.toByteArray();
    }
}
