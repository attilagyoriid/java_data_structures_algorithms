package com.ag.java.algo.sorts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @Test
    void sort() {
        int[] list = {4,3,6,1,7,8,2};
        BubbleSort.sort(list);
        Assertions.assertArrayEquals(new int[]{1,2,3,4,6,7,8},list);
    }

    @Test
    void sort_duplicates() {
        int[] list = {4,3,6,1,6,7,8,2,3};
        BubbleSort.sort(list);
        Assertions.assertArrayEquals(new int[]{1,2,3,3,4,6,6,7,8},list);
    }

    @Test
    void sort_one_item() {
        int[] list = {4};
        BubbleSort.sort(list);
        Assertions.assertArrayEquals(new int[]{4},list);
    }

    @Test
    void sort_empty() {
        int[] list = {};
        BubbleSort.sort(list);
        Assertions.assertArrayEquals(new int[]{},list);
    }
}