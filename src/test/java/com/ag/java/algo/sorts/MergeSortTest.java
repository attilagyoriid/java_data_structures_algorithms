package com.ag.java.algo.sorts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    void sort() {
        int[] arrayToSort = new int[]{4,3,5,2,1,8,9};
        int[] resultArray = MergeSort.sort(arrayToSort);
        Assertions.assertArrayEquals(new int[]{1,2,3,4,5,8,9}, resultArray);
    }
}