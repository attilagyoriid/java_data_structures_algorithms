package com.ag.java.algo.arrays;

import java.security.InvalidParameterException;
import java.util.*;
import java.util.stream.IntStream;

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

    public static int[] twoSum(int[] list, int number) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        int currentDiff = 0;
        for (int i = 0; i < list.length; i++) {
            currentDiff = number - list[i];
            if (map.containsKey(currentDiff)) {
                result[0] = map.get(currentDiff);
                result[1] = i;
                return result;
            }
            map.put(list[i], i);

        }
        return result;
    }

    /**
     * Find Duplicates
     * in O(n) time and O(1) space
     *
     * @param list
     * @return duplicates
     */
    public static List findDuplicates(int[] list) {
        List<Integer> result = new ArrayList<>();

        for (int l : list) {
            l = Math.abs(l);
            if (list[l - 1] < 0) {
                result.add(l);

            }
            list[l - 1] = -1 * list[l - 1];
        }

        return result;
    }

    /**
     * First Missing Positive Number time O(n) space O(1)
     * @param list
     * @return first missing positive number
     */
    public static int firstMissingPositive(int[] list) {
        // negative cant be the smallest positive, null out
        for (int i = 0; i < list.length; i++) {
            if (list[i] < 0) {
                list[i] = 0;
            }
        }
        for (int i = 0; i < list.length; i++) {
            int value = Math.abs(list[i]);
            if (value >= 1 && value <= list.length) { // in the bound of the array index
                if (list[value-1] > 0) { // we mark index for the number with minus
                    list[value-1] = -1 * list[value-1];
                } else if (list[value-1] == 0) { // if it is nulled out 0 then assign out of bound negative value
                    list[value-1] = -1 * (list.length + 1);
                }

            }
        }
        for (int i = 1; i <= list.length; i++) {
            if (list[i-1] >= 0 ) {
                return i;
            }
        }

        return list.length + 1;
    }

    /**
     * Missing Number
     * @param numbers
     * @return the missing number in the array or n + 1
     */
    public static int missingNumber(int[] numbers) {
        int[] expectedArray = IntStream.rangeClosed(0, numbers.length).toArray();
        int result = Arrays.stream(expectedArray).sum() - Arrays.stream(numbers).sum();
        if (result == 0) {
            return numbers.length;
        }
        return result;
    }

    public static int missingNumber2(int[] numbers) {
        int result = numbers.length;
        for (int i = 0; i < numbers.length; i++) {
            result += (i-numbers[i]);
        }
        if (result == 0) {
            return numbers.length;
        }
        return result;
    }

    public static int maximumSubarray(int[] list) {
        int currentMax = 0;
        int max = 0;

        for (int l : list) {

            if (currentMax < 0) {
                currentMax = 0;
            }
            currentMax += l;
            max = Math.max(max, currentMax);

        }
        return max;
    }

    public static List<Integer> minimumLengthSubarray(int[] list, int referenceNumberToBeGreaterThan) {
        int left = 0;
        int right = 0;
        int currentValue = list[0];
        int maxLeft = list.length + 1;
        int maxRight = 2 * (list.length + 1);
        List<Integer> result = new ArrayList<>();
        while (left <= right && right < list.length - 1) {

            if (currentValue > referenceNumberToBeGreaterThan) {
                currentValue -= list[left];

                if (maxRight - maxLeft > right - left) {
                    maxLeft = left;
                    maxRight = right;
                }
                left++;

            } else {
                right++;
                currentValue += list[right];
            }

        }

        for (int i = maxLeft; i <= maxRight; i++) {
            result.add(list[i]);
        }

        return result;
    }

    /**
     * Merge Intervals
     *
     * @param intervals
     * @return
     */
    public static List<List<Integer>> mergeIntervals(List<List<Integer>> intervals) {
        if (intervals.size() < 2) {
            return intervals;
        }
        Collections.sort(intervals, Comparator.comparingInt(list -> list.get(0)));


        int actualStart = 0;
        int actualEnd = 0;
        int previousEnd = 0;
        List<List<Integer>> result = new ArrayList<>();
        result.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            actualStart = intervals.get(i).get(0);
            actualEnd = intervals.get(i).get(1);
            previousEnd = result.get(result.size() - 1).get(1);

            if (previousEnd >= actualStart) {
                result.get(result.size() - 1).set(1, Math.max(previousEnd, actualEnd)); // max because: [1,5] [2,4]
            } else {
                result.add(Arrays.asList(new Integer[]{actualStart, actualEnd}));
            }
        }

        return result;


    }

    /**
     * Non-Overlapping Intervals
     * Count overlapping intervals
     *
     * @param intervals
     * @return
     */
    public static int nonOverlappingIntervals(List<List<Integer>> intervals) {
        if (intervals.size() < 2) {
            return 0;
        }
        Collections.sort(intervals, Comparator.comparingInt(list -> list.get(0)));


        int actualStart = 0;
        int actualEnd = 0;
        int previousEnd = intervals.get(0).get(1);
        int result = 0;
        for (int i = 1; i < intervals.size(); i++) {
            actualStart = intervals.get(i).get(0);
            actualEnd = intervals.get(i).get(1);

            if (actualStart >= previousEnd) {
                previousEnd = actualEnd;
            } else {
                result += 1;
                previousEnd = Math.min(previousEnd, actualEnd);
            }
        }

        return result;
    }
}
