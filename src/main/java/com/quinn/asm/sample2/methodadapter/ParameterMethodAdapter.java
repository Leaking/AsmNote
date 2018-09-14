package com.quinn.asm.sample2.methodadapter;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.ArrayList;
import java.util.List;

public class ParameterMethodAdapter extends MethodVisitor implements Opcodes {

    private String methodName;

    public ParameterMethodAdapter(String methodName, final MethodVisitor mv) {
        super(ASM5, mv);
        this.methodName = methodName;
        System.out.println("methodName " + methodName);
    }

    private List<Integer> indexes = new ArrayList<>();
    private List<String> names = new ArrayList<>();

    @Override
    public void visitLocalVariable(String name, String descriptor, String signature, Label start, Label end, int index) {
        super.visitLocalVariable(name, descriptor, signature, start, end, index);
        System.out.println(methodName + " >  " + descriptor + " > " + name + " " + this);
        if(!"this".equals(name)) {
//            System.out.println("ADD" + this);
            indexes.add(index);
            names.add(name);
        }
    }


    @Override
    public void visitInsn(int opcode) {

        if ((opcode >= IRETURN && opcode <= RETURN) || opcode == ATHROW) {
            System.out.println(names.size() + "" + this);
            mv.visitLdcInsn("Demo");
            mv.visitTypeInsn(NEW, "java/lang/StringBuilder");
            mv.visitInsn(DUP);
            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "()V", false);
            for(int i = 0; i < indexes.size(); i++) {
                if(i != 0) {
                    mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
                }
                mv.visitLdcInsn(names.get(i));
                mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
                mv.visitVarInsn(ALOAD, indexes.get(i));
            }
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;", false);
            mv.visitMethodInsn(INVOKESTATIC, "com/quinn/asm/library/Log", "i", "(Ljava/lang/String;Ljava/lang/String;)V", false);

        }
        super.visitInsn(opcode);
    }
}
