package com.ag.java.algo.sorts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {

    @Test
    void sort() {
        int[] array = new int[]{1,2,3,4,8,9};
        InsertionSort.sort(array);
        Assertions.assertArrayEquals(new int[]{1,2,3,4,8,9}, array);
    }

    @Test
    void sort_empty() {
        int[] array = new int[]{};
        InsertionSort.sort(array);
        Assertions.assertArrayEquals(new int[]{}, array);
    }

    @Test
    void sort_one_item() {
        int[] array = new int[]{5};
        InsertionSort.sort(array);
        Assertions.assertArrayEquals(new int[]{5}, array);
    }
}