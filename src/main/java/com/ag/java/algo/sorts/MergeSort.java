package com.ag.java.algo.sorts;

import java.util.Arrays;

public class MergeSort {

    public static int[] sort(int[] array) {

        if (array.length == 1) {
            return array;
        }
        int midIndex = array.length / 2;
        int[] leftArray = sort(Arrays.copyOfRange(array, 0, midIndex));
        int[] rightArray = sort(Arrays.copyOfRange(array, midIndex, array.length));
        return merge(leftArray, rightArray);
    }

    private static int[] merge(int[] leftArray, int[] rightArray) {
        int[] combinedArray = new int[leftArray.length + rightArray.length];
        int index = 0;
        int i = 0;
        int j = 0;

        while (i < leftArray.length && j < rightArray.length) {

            if (leftArray[i] < rightArray[j]) {
                combinedArray[index] = leftArray[i];
                index++;
                i++;

            } else {
                combinedArray[index] = rightArray[j];
                index++;
                j++;
            }

        }

        while (i < leftArray.length) {
            combinedArray[index] = leftArray[i];
            i++;
            index++;
        }
        while (j < rightArray.length) {
            combinedArray[index] = rightArray[j];
            j++;
            index++;
        }
        return combinedArray;
    }
}
