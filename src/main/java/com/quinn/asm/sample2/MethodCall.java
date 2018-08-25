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
    }
}
