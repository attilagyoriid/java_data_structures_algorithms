package com.ag.java.algo.arrays;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArraysX {

    /**
     * Array: Remove Element
     * <p>
     * In this problem, we are given an array of integers nums and a value val.
     * The goal is to remove all occurrences of val in-place from the array and return the new length of the array after removal.
     */

    public static int removeElement(int[] nums, int val) {

        int j = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }

        }
        return j;
    }

    /**
     * Array: Find Max Min
     * <p>
     * In this problem, you are given an array of integers,
     * and the task is to write a method that finds the maximum and minimum numbers in the array.
     */
    public static int[] findMaxMin(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {

            if (min > nums[i]) {
                min = nums[i];
            }
            if (max < nums[i]) {
                max = nums[i];
            }

        }
        return new int[]{max, min};

    }

    /**
     * Array: Max Profit | Best Time to Buy and Sell a Stock
     * <p>
     * You are tasked with implementing a method, maxProfit that takes an array of integers representing the price of a given stock on different days.
     * <p>
     * The method should determine the maximum profit that can be made by buying and selling the stock once. Note that you must buy before you can sell.
     */
    public static int maxProfitTwoPointers(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int maxProfit = 0;
        int buyL = 0;
        int sellR = 1;

        while (sellR < prices.length) {

            if (prices[buyL] < prices[sellR]) {

                maxProfit = Math.max(maxProfit, prices[sellR] - prices[buyL]);

            } else {
                buyL = sellR;
            }
            sellR++;
        }

        return maxProfit;
    }

    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            int profit = price - minPrice;
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }

    /**
     * Array: Max Profit | Best Time to Buy and Sell a Stock II
     * <p>
     * You are tasked with implementing a method, maxProfit that takes an array of integers representing the price of a given stock on different days.
     * <p>
     * The method should determine the maximum aggregated profit that can be made by buying and selling the stock. Note that you must buy before you can sell.
     */
    public static int maxProfitTwoPointersAggregate(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int aggregateProfit = 0;
        int buyL = 0;
        int sellR = 1;

        while (sellR < prices.length) {

            if (prices[buyL] < prices[sellR]) {

                aggregateProfit += prices[sellR] - prices[buyL];

            }
            buyL++;
            sellR++;
        }

        return aggregateProfit;
    }

    public static int maxProfitAggregate(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int aggregateProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                aggregateProfit += prices[i] - prices[i - 1];
            }

        }
        return aggregateProfit;
    }

    /**
     * Number of Notes
     *
     * @param amount amount to break down by notes
     * @return number of notes
     */
    public static Map<Integer, Integer> getNumberOfNotes(int amount) {
        if (amount < 1) {
            throw new InvalidParameterException("Amount should be greater than 1");
        }
        var notes = Arrays.asList(1000, 500, 200, 100, 50, 10, 5, 1);

        var numberOfNotes = new HashMap<Integer, Integer>();

        for (int i = 0; i < notes.size(); i++) {
            while ((amount / notes.get(i) >= 1)) {
                if (numberOfNotes.getOrDefault(notes.get(i), 0) == 0) {
                    numberOfNotes.put(notes.get(i), 1);
                } else {
                    numberOfNotes.put(notes.get(i), numberOfNotes.get(notes.get(i)) + 1);
                }

                amount = amount - notes.get(i);

            }
        }


        return numberOfNotes;
    }

    /**
     * Best Time to Buy and Sell Stock
     *
     * @param prices
     * @return maximum profit
     */
    public static int buyAndSellStock(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int buy = 0;
        int sell = 1;
        int maxProfit = 0;
        while (sell < prices.length) {

            if (prices[sell] > prices[buy]) {
                maxProfit = Math.max(maxProfit, prices[sell] - prices[buy]);
            } else {
                buy = sell;
            }
            sell++;
        }
        return maxProfit;
    }

}
