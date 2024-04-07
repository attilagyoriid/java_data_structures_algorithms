package com.ag.java.algo.heap;

import java.util.ArrayList;
import java.util.List;

public class HeapX {
    private List<Integer> heap;

    public HeapX() {
        this.heap = new ArrayList<>();
    }

    public List<Integer> getHeap() {
        return new ArrayList<>(heap);
    }

    private int getLeftChildIndex(int index) {

        return 2 * index + 1;

    }

    private int getRightChildIndex(int index) {

        return 2 * index + 2;

    }

    private int getParentIndex(int index) {

        return (index - 1) / 2;

    }

    private void swap(int index1, int index2) {

        int temp = heap.get(index1);
        heap.set(index1,heap.get(index2));
        heap.set(index2,temp);

    }

    public void insert(int value) {
        heap.add(value);
        int currentIndex = heap.size()-1;
        while (currentIndex>0 && heap.get(currentIndex)>heap.get(getParentIndex(currentIndex))) {
            int parentIndex = getParentIndex(currentIndex);
            swap(currentIndex, parentIndex);
            currentIndex = parentIndex;

        }

    }

}
