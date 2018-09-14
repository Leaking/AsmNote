package com.quinn.asm.sample2.target;

import com.quinn.asm.sample2.handler.LogManager;

public class MethodCallTimingLog {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();printOne();
        printTwo();
        printTwo();
        long ellapse = System.currentTimeMillis() - start;LogManager.log("main", ellapse); }

    private static void printOne() {
        long start = System.currentTimeMillis();
        System.out.println("Hello World");
        long ellapse = System.currentTimeMillis() - start;LogManager.log("main", ellapse); }

    private static void printTwo() {
        long start = System.currentTimeMillis();
        printOne();
        printOne();
        long ellapse = System.currentTimeMillis() - start;LogManager.log("main", ellapse); }

}
