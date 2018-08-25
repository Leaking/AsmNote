package com.quinn.asm.asmfier;

import org.objectweb.asm.util.ASMifier;

import java.io.IOException;

public class ASMifierTool {

    public static void main(String[] args) {
        asmifier("/Users/quinn/Documents/workspaces/asmnote/out/production/classes/com/quinn/asm/sample2/MethodCallInstrumented.class");
    }

    public static void asmifier(String path) {
        String[] params = {path};
        try {
            ASMifier.main(params);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
