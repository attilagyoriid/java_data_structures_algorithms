package com.ag.java.algo.sorts;

public class BubbleSort {
//    {4,3,6,1,7,8,2}
    public static void sort(int[] list) { // every time the latest number will get into its ordered place
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
