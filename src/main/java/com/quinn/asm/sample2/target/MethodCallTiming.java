package com.quinn.asm.sample2.target;

public class MethodCallTiming {

    public static void main(String[] args) {
        printOne();
        printTwo();
        printTwo();
    }

    private static void printOne() {
        long start = System.currentTimeMillis();
        System.out.println("Hello World");
        long ellapse = System.currentTimeMillis() - start;
        System.out.println("ellapse " + ellapse);
    }

    private static void printTwo() {
        printOne();
        printOne();
    }
}
