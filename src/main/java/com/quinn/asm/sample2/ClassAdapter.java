package com.quinn.asm.sample2;

import com.quinn.asm.sample2.methodAdapter.MethodAdapterCall;
import com.quinn.asm.sample2.methodAdapter.MethodAdapterTiming;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class ClassAdapter extends ClassVisitor implements Opcodes {

    public ClassAdapter(final ClassVisitor cv) {
        super(ASM5, cv);
    }

    @Override
    public MethodVisitor visitMethod(final int access, final String name,
                                     final String desc, final String signature, final String[] exceptions) {
        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
        return mv == null ? null : new MethodAdapterTiming(mv);
    }
}
