package com.ag.java.algo.arrays;

import com.ag.java.algo.arrays.ArraysX;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArraysXTest {

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
        Assertions.assertEquals(4, ArraysX.removeElement(nums, val));
    }
    @Test
    void removeElement_empty() {
        int[] nums = {};
        int val = 2;
        Assertions.assertEquals(0, ArraysX.removeElement(nums, val));
    }

    @Test
    void removeElement_no_value() {
        int[] nums = {1, 2, 3, 4, 2, 1, 2};
        int val = 5;
        Assertions.assertEquals(7, ArraysX.removeElement(nums, val));
    }

    /**
     * Array: Find Max Min
     *
     * In this problem, you are given an array of integers,
     * and the task is to write a method that finds the maximum and minimum numbers in the array.
     */
    @Test
    void findMaxMin() {
        int[] nums = new int[] {5, 3, 8, 1, 6, 9};
        Assertions.assertArrayEquals(new int[] { 9, 1}, ArraysX.findMaxMin(nums));
    }

    /**
     * Array: Max Profit | Best Time to Buy and Sell a Stock
     *
     * You are tasked with implementing a method, maxProfit that takes an array of integers representing the price of a given stock on different days.
     *
     * The method should determine the maximum profit that can be made by buying and selling the stock once. Note that you must buy before you can sell.
     */
    @Test
    void maxProfit_Descending() {
        int[] prices = new int[] {6, 5, 4, 3, 2, 1};
        Assertions.assertEquals(0, ArraysX.maxProfitTwoPointers(prices));
        Assertions.assertEquals(0, ArraysX.maxProfit(prices));
    }

    @Test
    void maxProfit_Ascending() {
        int[] prices = new int[] {1,2,3,4,5,6};
        Assertions.assertEquals(5, ArraysX.maxProfitTwoPointers(prices));
        Assertions.assertEquals(5, ArraysX.maxProfit(prices));
    }

    @Test
    void maxProfit_Empty() {
        int[] prices = new int[] {};
        Assertions.assertEquals(0, ArraysX.maxProfitTwoPointers(prices));
        Assertions.assertEquals(0, ArraysX.maxProfit(prices));
    }

    @Test
    void maxProfit_OneItem() {
        int[] prices = new int[] {1};
        Assertions.assertEquals(0, ArraysX.maxProfitTwoPointers(prices));
        Assertions.assertEquals(0, ArraysX.maxProfit(prices));
    }

    @Test
    void maxProfit_Mix() {
        int[] prices = new int[] {2,1,3,6,5,7,8,3};
        Assertions.assertEquals(7, ArraysX.maxProfitTwoPointers(prices));
        Assertions.assertEquals(7, ArraysX.maxProfit(prices));
    }

    /**
     * Array: Max Profit | Best Time to Buy and Sell a Stock II
     *
     * You are tasked with implementing a method, maxProfit that takes an array of integers representing the price of a given stock on different days.
     *
     * The method should determine the maximum aggregated profit that can be made by buying and selling the stock. Note that you must buy before you can sell.
     */
    @Test
    void maxProfitTwoPointersAggregate_Mix() {
        int[] prices = new int[] {7,1,5,3,6,4};
        Assertions.assertEquals(7, ArraysX.maxProfitTwoPointersAggregate(prices));
    }
    @Test
    void maxProfitTwoPointersAggregate_Descending() {
        int[] prices = new int[] {6, 5, 4, 3, 2, 1};
        Assertions.assertEquals(0, ArraysX.maxProfitTwoPointersAggregate(prices));
    }

    @Test
    void maxProfitTwoPointersAggregate_Ascending() {
        int[] prices = new int[] {1,2,3,4,5,6};
        Assertions.assertEquals(5, ArraysX.maxProfitTwoPointersAggregate(prices));
    }

    @Test
    void maxProfitTwoPointersAggregate_Empty() {
        int[] prices = new int[] {};
        Assertions.assertEquals(0, ArraysX.maxProfitTwoPointersAggregate(prices));
    }

    @Test
    void maxProfitTwoPointersAggregate_OneItem() {
        int[] prices = new int[] {1};
        Assertions.assertEquals(0, ArraysX.maxProfitTwoPointersAggregate(prices));
    }

    @Test
    void maxProfitAggregate_Mix() {
        int[] prices = new int[] {7,1,5,3,6,4};
        Assertions.assertEquals(7, ArraysX.maxProfitAggregate(prices));
    }
    @Test
    void maxProfitAggregate_Descending() {
        int[] prices = new int[] {6, 5, 4, 3, 2, 1};
        Assertions.assertEquals(0, ArraysX.maxProfitAggregate(prices));
    }

    @Test
    void maxProfitAggregate_Ascending() {
        int[] prices = new int[] {1,2,3,4,5,6};
        Assertions.assertEquals(5, ArraysX.maxProfitAggregate(prices));
    }

    @Test
    void maxProfitAggregate_Empty() {
        int[] prices = new int[] {};
        Assertions.assertEquals(0, ArraysX.maxProfitAggregate(prices));
    }

    @Test
    void maxProfitAggregate_OneItem() {
        int[] prices = new int[] {1};
        Assertions.assertEquals(0, ArraysX.maxProfitAggregate(prices));
    }


}