package com.quinn.asm.sample2.methodadapter;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

class CallMethodAdapter extends MethodVisitor implements Opcodes {

    public CallMethodAdapter(final MethodVisitor mv) {
        super(ASM5, mv);
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {

        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitLdcInsn("CALL println");
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);

        /* do call */
        mv.visitMethodInsn(opcode, owner, name, desc, itf);


        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitLdcInsn("RETURN " + name);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);

    }



    @Override
    public void visitParameter(String name, int access) {
        System.out.println("name " + name);
        super.visitParameter(name, access);
    }
}
