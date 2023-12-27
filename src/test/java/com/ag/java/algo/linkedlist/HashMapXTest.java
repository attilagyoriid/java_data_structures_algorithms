package com.ag.java.algo.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HashMapXTest {

    /**
     * Two Sum
     */
    @Test
    void twoSum_happy() {
        HashMapX hashMapX = new HashMapX();
        Assertions.assertIterableEquals(List.of(1,3), hashMapX.twoSum(List.of(2,1,5,3),4));
    }

    @Test
    void twoSum_failure() {
        HashMapX hashMapX = new HashMapX();
        Assertions.assertIterableEquals(List.of(), hashMapX.twoSum(List.of(2,1,5,3),2));
    }
}