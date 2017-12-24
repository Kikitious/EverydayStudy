package com.katherine.du.everydaystudy.up20171223;

/**
 * Created by du on 17/12/23.
 */

public class Sort {


    public static void main(String[] args) {
        int[] a = new int[]{60, 71, 49, 11, 82, 49, 3, 66};


//        directInsertSort(a);
        //shellSort(a);
//        bubbleSort(a);
        printArray(quickSort(a, 0, a.length - 1));

    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
        System.out.println();
    }

    public static int[] quickSort(int[] array, int low, int high) {
        if (low < high) {
            int i = low;
            int j = high;
            int key = array[i];
            while (i < j) {
                while (i < j && key <= array[j]) {
                    j--;
                }
                array[i] = array[j];
                while (i < j && key >= array[i]) {
                    i++;
                }
                array[j] = array[i];
            }
            array[i] = key;
            printArray(array);
            quickSort(array, low, i - 1);
            quickSort(array, i + 1, high);
        }
        return array;
    }

    public static int[] bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            printArray(array);
        }
        return array;
    }


    public static int[] shellSort(int[] array) {
        int n = array.length;
        int d = n / 2;
        while (d >= 1) {
            for (int i = d; i < n; i++) {
                int temp = array[i];
                int j = i - d;
                while (j >= 0 && temp < array[j]) {
                    array[j + d] = array[j];
                    j = j - d;
                }
                array[j + d] = temp;
            }
            d = d / 2;
            printArray(array);
        }
        return array;
    }

    public static int[] directInsertSort(int[] array) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            int temp = array[i];
            int j = i - 1;

            while (j >= 0 && temp < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
            printArray(array);
        }
        return array;
    }

}
