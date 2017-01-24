package com.golovach.courses;

public class BackwordFor {
    public static void main(String[] args) {
        int k;
        for (k = 0; k < 10; k++) {
            k -= 2;
        }
        System.out.println(k);
    }
}

