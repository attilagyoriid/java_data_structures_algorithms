package com.ag.java.algo.linkedlist;

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
     *
     * You are tasked with implementing a method, maxProfit that takes an array of integers representing the price of a given stock on different days.
     *
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
     *
     * You are tasked with implementing a method, maxProfit that takes an array of integers representing the price of a given stock on different days.
     *
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

}
