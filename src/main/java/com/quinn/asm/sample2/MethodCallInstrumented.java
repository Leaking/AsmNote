package com.quinn.asm.sample2;

public class MethodCallInstrumented {

    public static void main(String[] args) {
        System.out.println("CALL printOne");
        printOne();
        System.out.println("RETURN printOne");

        System.out.println("CALL printOne");
        printOne();
        System.out.println("RETURN printOne");

        System.out.println("CALL printTwo");
        printTwo();
        System.out.println("RETURN printTwo");
    }

    public static void printOne() {
        System.out.println("CALL println");
        System.out.println("Hello World");
        System.out.println("RETURN println");
    }

    public static void printTwo() {
        System.out.println("CALL printOne");
        printOne();
        System.out.println("RETURN printOne");

        System.out.println("CALL printOne");
        printOne();
        System.out.println("RETURN printOne");
    }

}
