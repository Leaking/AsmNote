package com.quinn.asm.sample2.target;

public class MethodCallTiming {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();printOne();
        printTwo();
        printTwo();
        long ellapse = System.currentTimeMillis() - start; }

    private static void printOne() {
        long start = System.currentTimeMillis();
        System.out.println("Hello World");
        long ellapse = System.currentTimeMillis() - start; }

    private static void printTwo() {
        long start = System.currentTimeMillis();
        printOne();
        printOne();
        long ellapse = System.currentTimeMillis() - start; }



}
