package com.quinn.asm.sample2.methodAdapter;


import com.sun.org.apache.bcel.internal.generic.INVOKESTATIC;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.LocalVariablesSorter;

public class MethodAdapterTimingVarSorter extends LocalVariablesSorter implements Opcodes {

    private int startVarIndex;

    public MethodAdapterTimingVarSorter(int access, String desc, MethodVisitor mv) {
        super(Opcodes.ASM6, access, desc, mv);
    }


    @Override
    public void visitCode() {
        super.visitCode();
        mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
        startVarIndex = newLocal(Type.LONG_TYPE);
        mv.visitVarInsn(Opcodes.LSTORE, startVarIndex);
    }


    @Override
    public void visitInsn(int opcode) {
        if ((opcode >= IRETURN && opcode <= RETURN) || opcode == ATHROW) {
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
            mv.visitVarInsn(Opcodes.LLOAD, startVarIndex);
            mv.visitInsn(Opcodes.LSUB);
            int index = newLocal(Type.LONG_TYPE);
            mv.visitVarInsn(Opcodes.LSTORE, index);
        }
        super.visitInsn(opcode);
    }


    @Override
    public void visitMaxs(int maxStack, int maxLocals) {
        super.visitMaxs(maxStack+4, maxLocals);
    }
}
