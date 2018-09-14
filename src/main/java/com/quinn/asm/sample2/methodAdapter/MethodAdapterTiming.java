package com.quinn.asm.sample2.methodAdapter;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class MethodAdapterTiming extends MethodVisitor implements Opcodes {

    public MethodAdapterTiming(final MethodVisitor mv) {
        super(ASM6, mv);
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {

        /* do call */
        mv.visitMethodInsn(opcode, owner, name, desc, itf);

    }

    @Override
    public void visitCode() {
        super.visitCode();
        mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
        mv.visitVarInsn(Opcodes.LSTORE, 20);
    }
}
