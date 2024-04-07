package com.ag.java.algo.heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HeapXTest {

    @Test
    void insert() {
        HeapX heap = new HeapX();
        heap.insert(99);
        heap.insert(72);
        heap.insert(61);
        heap.insert(58);
        heap.insert(100);
        heap.insert(75);

        Assertions.assertIterableEquals(List.of(100,99,75,58,72,61), heap.getHeap());
    }
}