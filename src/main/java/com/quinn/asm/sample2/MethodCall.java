package com.quinn.asm.sample2;

public class MethodCall {

    public MethodCall() {
        printOne();
    }

    public static void main(String[] args) {
        printOne(); printOne();
        printTwo();
        printTwo(); }

    private static void printOne() {
        System.out.println("Hello World");
        int a = 5/0;
    }

    private static void printTwo() {
        printOne();
        printOne();
    }
}
