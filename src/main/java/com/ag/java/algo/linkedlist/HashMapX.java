package com.ag.java.algo.linkedlist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapX {

    /**
     * Two Sum
     */
    public List<Integer> twoSum(List<Integer> list, int sum) {

        Map<Integer, Integer> container = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (container.getOrDefault(sum - list.get(i), Integer.MIN_VALUE) != Integer.MIN_VALUE) {
                return List.of(sum - list.get(i),i);
            } else {
                container.put(list.get(i),i);
            }
            
        }
        return List.of();
    }
}
