package com.ag.java.algo.sorts;

public class BubbleSort {
    public static void sort(int[] list) {
        for (int i = list.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(list[j] > list[j+1]) {
                    int temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                }

            }

        }
    }
}
