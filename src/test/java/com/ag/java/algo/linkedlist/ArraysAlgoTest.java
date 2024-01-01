package com.ag.java.algo.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArraysAlgoTest {

    /**
     * Array: Remove Element
     *
     * In this problem, we are given an array of integers nums and a value val.
     * The goal is to remove all occurrences of val in-place from the array and return the new length of the array after removal.
     */
    @Test
    void removeElement() {
        int[] nums = {1, 2, 3, 4, 2, 1, 2};
        int val = 2;
        Assertions.assertEquals(4, ArraysAlgo.removeElement(nums, val));
    }
    @Test
    void removeElement_empty() {
        int[] nums = {};
        int val = 2;
        Assertions.assertEquals(0, ArraysAlgo.removeElement(nums, val));
    }

    @Test
    void removeElement_no_value() {
        int[] nums = {1, 2, 3, 4, 2, 1, 2};
        int val = 5;
        Assertions.assertEquals(7, ArraysAlgo.removeElement(nums, val));
    }
}