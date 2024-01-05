package com.ag.java.algo.sorts;

public class QuickSort {

    public static void sort(int[] array) {

        sort(array, 0, array.length - 1);

    }

    private static void sort(int[] array, int indexLeft, int indexRight) {

        if (indexLeft < indexRight) {

            int pivot = pivot(array, indexLeft, indexRight);
            sort(array, indexLeft, pivot - 1);
            sort(array, indexRight, pivot + 1);

        }


    }

    private static int pivot(int[] array, int pivotIndex, int rightIndex) {
        int swapIndex = pivotIndex;

        for (int i = pivotIndex + 1; i <= rightIndex; i++) {

            if (array[pivotIndex] > array[i]) {
                swapIndex++;
                swap(array, swapIndex, i);
            }
        }
        swap(array, swapIndex, pivotIndex);
        return swapIndex;

    }


    private static void swap(int[] array, int indexLeft, int indexRight) {
        int temp = array[indexLeft];
        array[indexLeft] = array[indexRight];
        array[indexRight] = temp;
    }
}
