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
        int buy = 0; // left pointer
        int sell = 1; // right pointer
        int maxProfit = 0;
        while (sell < prices.length) {

            if (prices[sell] > prices[buy]) { // is it profitable?
                maxProfit = Math.max(maxProfit, prices[sell] - prices[buy]);
            } else {
                buy = sell; // sell price is low so update buy to sell
            }
            sell++;
        }
        return maxProfit;
    }

    public static int containerWithMostWater(List<Integer> container) {

        int left = 0, right = container.size() - 1; // maximize the width on the axes
        int maxWater = 0;
        int currentWater = 0;

        while (left < right) {

            currentWater = (right - left) * Math.min(container.get(left), container.get(right));
            maxWater = Math.max(maxWater, currentWater);
            if (container.get(left) < container.get(right)) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;

    }


    /**
     * Returns the indexes of the two umber adding up to sum
     *
     * @param list
     * @param numberSum
     * @return the indexes of the two numberSum
     */
    public static int[] twoSum(int[] list, int numberSum) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        int currentDiff = 0;
        for (int i = 0; i < list.length; i++) {
            currentDiff = numberSum - list[i];
            if (map.containsKey(currentDiff)) { // is there a numberSum (the difference between current numberSum and the numberSum which is the final result) already in the map
                result[0] = map.get(currentDiff); // get the index of the previous numberSum which add up with the current numberSum to the sum
                result[1] = i; // current index + index from the map
                return result;
            }
            map.put(list[i], i);

        }
        return result;
    }

    /**
     * Detec is there any duplicate in the list
     *
     * @param list
     * @return
     */

    public static boolean containsDuplicate(List<Integer> list) {
        HashSet<Integer> duplicateDetectionSet = new HashSet<>();

        for (Integer i : list) {
            if (duplicateDetectionSet.contains(i)) {
                return true;
            }
            duplicateDetectionSet.add(i);
        }

        return false;
    }

    /**
     * Find Duplicates
     * in O(n) time and O(1) space
     * use indexes as placeholders to indicate that we already met with the given number
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
            list[l - 1] = -1 * list[l - 1]; // negate the index representing the number we already found
        }

        return result;
    }

    /**
     * First Missing Positive Number time O(n) space O(1)
     * we use indexes as placeholders for those numbers which in the list - negative flag
     *
     * @param list
     * @return first missing positive number
     */
    public static int firstMissingPositive(int[] list) {
        // negative can not be the smallest positive, null out
        for (int i = 0; i < list.length; i++) {
            if (list[i] < 0) {
                list[i] = 0;
            }
        }
        for (int i = 0; i < list.length; i++) {
            int value = Math.abs(list[i]);
            if (value >= 1 && value <= list.length) { // in the bound of the array index
                if (list[value - 1] > 0) { // disregard 0-s and we mark index for the number with minus as visited
                    list[value - 1] = -1 * list[value - 1];
                } else if (list[value - 1] == 0) { // if it is nulled out 0 then assign out of bound negative value
                    list[value - 1] = -1 * (list.length + 1);
                }

            }
        }
        for (int i = 1; i <= list.length; i++) { // find the number which is not nulled out and not negative
            if (list[i - 1] >= 0) {
                return i;
            }
        }

        return list.length + 1;
    }

    /**
     * Missing Number
     *
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

    public static int missingNumberBetterSpace(int[] numbers) {

        int result = Arrays.stream(numbers).sum();
        for (int i = 0; i < numbers.length + 1; i++) {
            result -= i;
        }
        return Math.abs(result);
    }

    public static int missingNumberXOR(int[] numbers) {
        int[] expectedArray = IntStream.rangeClosed(0, numbers.length).toArray();
        int result = 0;
        for (int i = 0; i < numbers.length; i++) {
            result = result ^ numbers[i] ^ expectedArray[i];
        }
        result = result ^ expectedArray[numbers.length];
        if (result == 0) {
            return numbers.length;
        }
        return result;
    }

    /**
     * Most naive is to create a hashset with list items, and cross out those being found: T: O(n), S: O(n)
     * Most optimal, we use indexes as expected array representation, and subtract actual array items from the indexes T:O(n) S:O(1)
     *
     * @param numbers
     * @return
     */

    public static int missingNumber2(int[] numbers) {
        int result = numbers.length; // the biggest value can be missing
        for (int i = 0; i < numbers.length; i++) {
            result += (i - numbers[i]);
        }

        return result;
    }

    /**
     * Find All Numbers Disappeared in an Array
     *
     * @param numbers
     * @return array of missing numbers
     */
    public static List<Integer> findAllNumbersDisappearedInArray(List<Integer> numbers) {
        ArrayList<Integer> result = new ArrayList<>();
        int currentIndex;
        for (Integer num : numbers) {
            currentIndex = Math.abs(num) - 1;
            numbers.set(currentIndex, -1 * Math.abs(numbers.get(currentIndex))); //[1,1,3,4,6,6] -> [-1,1,-3,-4,6,-6] -> by index - positive number: 2,5 is missing number

        }
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > 0) {
                result.add(i + 1);
            }
        }


        return result;

    }

    public static int maximumSubarray(int[] list) {
        int currentSum = 0;
        int maxSum = list[0]; // it can not be null because there are negative numbers in the list

        for (int l : list) {

            if (currentSum < 0) {
                currentSum = 0; // every time we have a negative prefix we remove it
            }
            currentSum += l; // if it becomes negative portion then we null it in the next iteration
            maxSum = Math.max(maxSum, currentSum);

        }
        return maxSum;
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
        // sort intervals by start value
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

            // overlapping previous end is greater or equal to new interval start,
            // keep the previous interval start value and
            // update previous interval end value
            if (actualStart <= previousEnd) {
                result.get(result.size() - 1).set(1, Math.max(previousEnd, actualEnd)); // take the end of most recently added end value and expand it
                // max because: [1,5] [2,4] we want to keep 5
            } else {
                result.add(Arrays.asList(actualStart, actualEnd));
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
        // sort intervals by starting points
        Collections.sort(intervals, Comparator.comparingInt(list -> list.get(0))); // time complexity is O(nlog), below is O(n) so entire is O(nlogn)


        int actualStart = 0;
        int actualEnd = 0;
        int previousEnd = intervals.get(0).get(1);
        int result = 0;
        for (int i = 1; i < intervals.size(); i++) {
            actualStart = intervals.get(i).get(0);
            actualEnd = intervals.get(i).get(1);
            // actual interval starts after the previous ends then its not overlapping
            if (actualStart >= previousEnd) {
                previousEnd = actualEnd;
            } else {
                result += 1;
                // we keep the interval with smaller end value cause there is less chance for it to be overlapping
                // we remove the longer interval
                previousEnd = Math.min(previousEnd, actualEnd);
            }
        }

        return result;
    }

    /**
     * Insert Interval
     *
     * @param intervals
     * @param newInterval
     * @return intervals with merged new interval
     */
    public static List<List<Integer>> insertInterval(List<List<Integer>> intervals, List<Integer> newInterval) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < intervals.size(); i++) {
            // if the new interval last element smaller than the first element of
            // the actual element of the interval, there will be no other overlapping,
            // new interval added and the rest of the interval
            if (newInterval.get(1) < intervals.get(i).get(0)) {
                result.add(newInterval);
                result.addAll(intervals.subList(i, intervals.size()));
                return result;
                // if the first element of the new interval is greater than the last element of
                // the actual interval, actual element can be added,
                // but there could have overlapping with other intervals
            } else if (newInterval.get(0) > intervals.get(i).get(1)) {
                result.add(intervals.get(i));
            } else {
                // if non of them then there is an overlapping with the current interval,
                // so new interval must be extended
                newInterval = Arrays.asList(Math.min(intervals.get(i).get(0), newInterval.get(0)), Math.max(intervals.get(i).get(1), newInterval.get(1)));
            }

        }
        // there was no overlapping, new interval added at the end of the result
        result.add(newInterval);
        return result;
    }

    public static boolean meetingRooms(List<List<Integer>> meetingRooms) {
        Collections.sort(meetingRooms, Comparator.comparingInt(list -> list.get(0))); // O(nlog)

        int previousEnd = meetingRooms.get(0).get(1);

        for (int i = 1; i < meetingRooms.size(); i++) {

            if (meetingRooms.get(i).get(0) < previousEnd) {
                return false;
            } else {
                previousEnd = meetingRooms.get(i).get(1);
            }

        }

        return true;


    }

}
