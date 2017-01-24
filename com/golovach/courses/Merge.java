package com.golovach.courses;

public class Merge {
    static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int aindex = 0;
        int bindex = 0;

        while ((aindex + bindex) != result.length) {
            if ((aindex < a.length) && (a[aindex] < b[bindex])) {
                result[aindex + bindex] = a[aindex];
                if (aindex < a.length)
                    aindex++;
            } else if (bindex < b.length) {
                result[aindex + bindex] = b[bindex];
                if (bindex < b.length)
                    bindex++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        int[] b = {2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(java.util.Arrays.toString(merge(a, b)));
    }
}
