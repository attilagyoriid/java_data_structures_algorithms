package com.ag.java.algo.sorts;

public class InsertionSort {
    public static void sort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int toBeInserted = array[i];
            int j = i - 1;
            while (j > -1 && toBeInserted < array[j]) {
                array[j + 1] = array[j];
                array[j] = toBeInserted;
                j--;
            }
        }
    }

}
