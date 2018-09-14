package com.quinn.asm.sample2;

<<<<<<< HEAD
import com.quinn.asm.sample2.methodadapter.ParameterMethodAdapter;
=======
import com.quinn.asm.sample2.methodAdapter.MethodAdapterCall;
import com.quinn.asm.sample2.methodAdapter.MethodAdapterTiming;
import com.quinn.asm.sample2.methodAdapter.MethodAdapterTimingVarSorter;
import com.quinn.asm.sample2.methodAdapter.MethodAdapterTimingVarSorterLog;
>>>>>>> c6c93b2c6ce590fb98d9f12852932aec3fb2bfd6
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.File;

public class ClassAdapter extends ClassVisitor implements Opcodes {

    private String className;

    public ClassAdapter(final ClassVisitor cv) {
        super(ASM6, cv);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        super.visit(version, access, name, signature, superName, interfaces);
        this.className = name;
    }


    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        super.visit(version, access, name, signature, superName, interfaces);
    }

    @Override
    public MethodVisitor visitMethod(final int access, final String name,
                                     final String desc, final String signature, final String[] exceptions) {
        System.out.println(name + " signature " + signature + " > " + desc);
        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
<<<<<<< HEAD
        return mv == null ? null : new ParameterMethodAdapter(name, mv);
=======
        return mv == null ? null : new MethodAdapterTimingVarSorterLog( className + File.separator + name, access, desc, mv);
>>>>>>> c6c93b2c6ce590fb98d9f12852932aec3fb2bfd6
    }



}
