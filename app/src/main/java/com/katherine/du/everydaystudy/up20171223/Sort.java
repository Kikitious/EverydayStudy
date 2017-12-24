package com.katherine.du.everydaystudy.up20171223;

/**
 * Created by du on 17/12/23.
 */

public class Sort {


    public static void main(String[] args) {
        int[] a = new int[]{60, 71, 49, 11, 82, 49, 3, 66};


        //printArray(directInsertSort(a));
        printArray(shellSort(a));

    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }


    public static int[] shellSort(int[] array) {
        int n = array.length;
        int i, j, d;
        int temp;
        d = n / 2;
        while (d >= 1) {
            for (i = d; i < n; i++) {
                temp = array[i];
                j = i - d;
                while (j >= 0 && temp < array[j]) {
                    array[j + d] = array[j];
                    j = j - d;
                }
                array[j + d] = temp;
            }
            d = d / 2;
        }
        return array;
    }

    public static int[] directInsertSort(int[] array) {
        int n = array.length;

        int i, j;
        int temp;

        for (i = 1; i < n; i++) {
            temp = array[i];
            j = i - 1;

            while (j >= 0 && temp < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
        return array;
    }

}
