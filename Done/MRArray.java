package Done;

import java.io.*;
import java.util.*;

public class MRArray {
    private static int TMP[] = {7, 3, 9, 2, 5, 1, 6, 0, 6, 3};
    private static int arr[] = new int[10];
    private File txt;
    private String fileName;

    private void sortLoToHi() {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    private void createFile() {
        fileName = new File("").getAbsolutePath() + "\\Done.MRArray.txt";
        txt = new File(fileName);
        try {
            txt.createNewFile();
        } catch (IOException e) {
            System.out.println("Error 1");
        }
    }

    private void writeArrToFile(int[] tmpArr) {
        try (FileWriter fw = new FileWriter(fileName)) {
            for (int i = 0; i < tmpArr.length; i++) {
                fw.write(tmpArr[i] + '0');
                fw.flush();
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Error 2");
        }

    }

    private void readArrFromFile() {
        try {
            Scanner sc = new Scanner(txt);
            sc.useDelimiter("");
            for (int i = 0; i < 10; i++) arr[i] = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Error 3");
        }
    }

    private void print() {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        MRArray mra = new MRArray();
        mra.createFile();
        mra.writeArrToFile(TMP);
        mra.readArrFromFile();
        mra.print();
        mra.sortLoToHi();
        mra.writeArrToFile(arr);
        mra.print();
    }
}
