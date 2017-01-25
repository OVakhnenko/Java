package com.golovach.courses;

// ((1+(0+1))+((0+1)+(1+(0+1))))
//
// 0
// 1
// 0+1
// 1+(0+1)
// ((0+1)+1+(0+1))
// ((1+(0+1))+((0+1)+(1+(0+1))))
//
public class FibonacciExpression {
    public static void main(String[] args) {
        System.out.println("((1+(0+1))+((0+1)+(1+(0+1))))");
        f(5);
    }

    public static int f(int x) {
        if (x < 2)
            return abc(x);
        else
            return a(x) + f(x - 2) + b(x) + f(x - 1) + c(x);
    }

    public static int abc(int x) {
        System.out.print(x);
        return x;
    }

    public static int a(int x) {
        //System.out.print("(");
        //System.out.print(x);
        if (x == 2)
            System.out.print("(");
        else if (!(x % 2 == 0)) {
            System.out.print("(");
        }
        return 0;
    }

    public static int b(int x) {
        System.out.print("+");
        return 0;
    }

    public static int c(int x) {
        if (x == 2)
            System.out.print(")");
        else if (!(x % 2 == 0)) {
            System.out.print(")");
        }
        //System.out.print(")");
        return 0;
    }
}
