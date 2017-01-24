package com.golovach.courses;

public class Fibonacci {
    public static void main(String[] args) {
        f(10);
    }

    public static int f(int x) {
        System.out.print(" " + x);
        return (x < 2) ? x : f(x - 2) + f(x - 1);
    }
}
