package com.quinn.asm.sample2;

public class MethodCall {


    public static void main(String[] args) {
        printOne(); printOne();
        printTwo();
        printTwo(); }

    private static void printOne() {
        System.out.println("Hello World");
    }

    private static void printTwo() {
        printOne();
        printOne();
        int a = 5/0;
    }

    private static void mutiReturn() {
        int a = 5;
        boolean flag = a / 2 == 2;
        if(flag) {
            printTwo();
            return;
        } else {
            printOne();
        }
        return;
    }
}
