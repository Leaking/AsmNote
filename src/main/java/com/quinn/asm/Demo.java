package com.quinn.asm;

import com.quinn.asm.library.Log;

public class Demo {


    public static final String classVar = "staticVal";
    private String var;

    public static void main(String[] args) {
        Demo demo = new Demo("varStr");
        demo.doSomething("say hello", true, 100);
    }

    public Demo(){

    }

    public Demo(String var) {
        this.var = var;
    }

    public void doSomething(String content, boolean flag, int count) {
        Log.i("Demo","content " + content + "flag " + flag + "count " + count);
    }

}
