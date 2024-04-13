package com.ag.java.algo.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ArraysXTest {

    /**
     * Array: Remove Element
     * <p>
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
     * <p>
     * In this problem, you are given an array of integers,
     * and the task is to write a method that finds the maximum and minimum numbers in the array.
     */
    @Test
    void findMaxMin() {
        int[] nums = new int[]{5, 3, 8, 1, 6, 9};
        Assertions.assertArrayEquals(new int[]{9, 1}, ArraysX.findMaxMin(nums));
    }

    /**
     * Array: Max Profit | Best Time to Buy and Sell a Stock
     * <p>
     * You are tasked with implementing a method, maxProfit that takes an array of integers representing the price of a given stock on different days.
     * <p>
     * The method should determine the maximum profit that can be made by buying and selling the stock once. Note that you must buy before you can sell.
     */
    @Test
    void maxProfit_Descending() {
        int[] prices = new int[]{6, 5, 4, 3, 2, 1};
        Assertions.assertEquals(0, ArraysX.maxProfitTwoPointers(prices));
        Assertions.assertEquals(0, ArraysX.maxProfit(prices));
    }

    @Test
    void maxProfit_Ascending() {
        int[] prices = new int[]{1, 2, 3, 4, 5, 6};
        Assertions.assertEquals(5, ArraysX.maxProfitTwoPointers(prices));
        Assertions.assertEquals(5, ArraysX.maxProfit(prices));
    }

    @Test
    void maxProfit_Empty() {
        int[] prices = new int[]{};
        Assertions.assertEquals(0, ArraysX.maxProfitTwoPointers(prices));
        Assertions.assertEquals(0, ArraysX.maxProfit(prices));
    }

    @Test
    void maxProfit_OneItem() {
        int[] prices = new int[]{1};
        Assertions.assertEquals(0, ArraysX.maxProfitTwoPointers(prices));
        Assertions.assertEquals(0, ArraysX.maxProfit(prices));
    }

    @Test
    void maxProfit_Mix() {
        int[] prices = new int[]{2, 1, 3, 6, 5, 7, 8, 3};
        Assertions.assertEquals(7, ArraysX.maxProfitTwoPointers(prices));
        Assertions.assertEquals(7, ArraysX.maxProfit(prices));
    }

    /**
     * Array: Max Profit | Best Time to Buy and Sell a Stock II
     * <p>
     * You are tasked with implementing a method, maxProfit that takes an array of integers representing the price of a given stock on different days.
     * <p>
     * The method should determine the maximum aggregated profit that can be made by buying and selling the stock. Note that you must buy before you can sell.
     */
    @Test
    void maxProfitTwoPointersAggregate_Mix() {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        Assertions.assertEquals(7, ArraysX.maxProfitTwoPointersAggregate(prices));
    }

    @Test
    void maxProfitTwoPointersAggregate_Descending() {
        int[] prices = new int[]{6, 5, 4, 3, 2, 1};
        Assertions.assertEquals(0, ArraysX.maxProfitTwoPointersAggregate(prices));
    }

    @Test
    void maxProfitTwoPointersAggregate_Ascending() {
        int[] prices = new int[]{1, 2, 3, 4, 5, 6};
        Assertions.assertEquals(5, ArraysX.maxProfitTwoPointersAggregate(prices));
    }

    @Test
    void maxProfitTwoPointersAggregate_Empty() {
        int[] prices = new int[]{};
        Assertions.assertEquals(0, ArraysX.maxProfitTwoPointersAggregate(prices));
    }

    @Test
    void maxProfitTwoPointersAggregate_OneItem() {
        int[] prices = new int[]{1};
        Assertions.assertEquals(0, ArraysX.maxProfitTwoPointersAggregate(prices));
    }

    @Test
    void maxProfitAggregate_Mix() {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        Assertions.assertEquals(7, ArraysX.maxProfitAggregate(prices));
    }

    @Test
    void maxProfitAggregate_Descending() {
        int[] prices = new int[]{6, 5, 4, 3, 2, 1};
        Assertions.assertEquals(0, ArraysX.maxProfitAggregate(prices));
    }

    @Test
    void maxProfitAggregate_Ascending() {
        int[] prices = new int[]{1, 2, 3, 4, 5, 6};
        Assertions.assertEquals(5, ArraysX.maxProfitAggregate(prices));
    }

    @Test
    void maxProfitAggregate_Empty() {
        int[] prices = new int[]{};
        Assertions.assertEquals(0, ArraysX.maxProfitAggregate(prices));
    }

    @Test
    void maxProfitAggregate_OneItem() {
        int[] prices = new int[]{1};
        Assertions.assertEquals(0, ArraysX.maxProfitAggregate(prices));
    }


    @Test
    void getNumberOfNotes() {
        Map<Integer, Integer> notes = ArraysX.getNumberOfNotes(1752);
        Assertions.assertEquals(1, notes.get(1000));
        Assertions.assertEquals(1, notes.get(500));
        Assertions.assertEquals(1, notes.get(200));
        Assertions.assertEquals(1, notes.get(50));
        Assertions.assertEquals(2, notes.get(1));

    }

    @Test
    void getNumberOfNotes_assert() {
        Exception exception = assertThrows(InvalidParameterException.class, () -> {
            ArraysX.getNumberOfNotes(-1);
        });
        Assertions.assertEquals("Amount should be greater than 1", exception.getMessage());

    }


    @Test
    void buyAndSellStock() {
        int[] prices = new int[]{2,1,5,6,2,8};
        Assertions.assertEquals(7, ArraysX.buyAndSellStock(prices));
    }

    @Test
    void twoSum() {
        int[] list = new int[]{2,1,5,6,2,8};
        Assertions.assertArrayEquals(new int[]{1,5}, ArraysX.twoSum(list,9));


    }

    @Test
    void findDuplicates() {
        int[] list = new int[]{2,1,5,6,2,5,7};
        Assertions.assertIterableEquals(List.of(2,5), ArraysX.findDuplicates(list));
    }

    @Test
    void maximumSubarray() {
        int[] list = new int[]{2,-3,5,-3,2,8,-2};
        Assertions.assertEquals(12, ArraysX.maximumSubarray(list));
    }

    @Test
    void minimumLengthSubarray() {
        int[] list = new int[]{2,1,5,6,2,5,7};
        System.out.println(ArraysX.minimumLengthSubarray(list,11));
        Assertions.assertIterableEquals(List.of(2,5), ArraysX.minimumLengthSubarray(list,11));
    }

    @Test
    void mergeIntervals() {
        List<List<Integer>> intervals = new ArrayList<>();
        intervals.add(Arrays.asList(new Integer[] { 2,8 }));
        intervals.add(Arrays.asList(new Integer[] { 8,11 }));
        intervals.add(Arrays.asList(new Integer[] { 12,16}));
        intervals.add(Arrays.asList(new Integer[] { 12,15}));

        List<List<Integer>> expectedIntervals = new ArrayList<>();
        expectedIntervals.add(Arrays.asList(new Integer[] { 2,11 }));
        expectedIntervals.add(Arrays.asList(new Integer[] { 12,16 }));

        Assertions.assertIterableEquals(expectedIntervals, ArraysX.mergeIntervals(intervals));
    }

    @Test
    void nonOverlappingIntervals() {
        List<List<Integer>> intervals = new ArrayList<>();
        intervals.add(Arrays.asList(new Integer[] { 1,2 }));
        intervals.add(Arrays.asList(new Integer[] { 2,3 }));
        intervals.add(Arrays.asList(new Integer[] { 3,4}));
        intervals.add(Arrays.asList(new Integer[] { 1,3}));

        Assertions.assertEquals(1, ArraysX.nonOverlappingIntervals(intervals));
    }
}