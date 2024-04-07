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
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);

    }

    /**
     * Insert at the end of the list first, then bubble up
     * @param value value to insert
     */
    public void insert(int value) {
        heap.add(value);
        int currentIndex = heap.size() - 1;
        while (currentIndex > 0 && heap.get(currentIndex) > heap.get(getParentIndex(currentIndex))) {
            int parentIndex = getParentIndex(currentIndex);
            swap(currentIndex, parentIndex);
            currentIndex = parentIndex;

        }

    }

    /**
     * remove root
     * @return root new max value
     */
    public Integer remove() {
        if (heap.size() == 0) {
            return null;
        }
        if (heap.size() == 1) {
            return heap.remove(0);
        }


        heap.set(0, heap.remove(heap.size() - 1));

        sinkDown(0);

        return heap.get(0);

    }

    /**
     * @param index <img src="src/main/resources/assets/heap_sinkdown.png">
     */
    private void sinkDown(int index) {
        int maxIndex = index;
        while (true) {
            int leftIndex = getLeftChildIndex(index);
            int rightIndex = getRightChildIndex(index);
            if (leftIndex < heap.size() && heap.get(leftIndex) > heap.get(maxIndex)) {
                maxIndex = leftIndex;
            }

            if (rightIndex < heap.size() && heap.get(rightIndex) > heap.get(maxIndex)) {
                maxIndex = rightIndex;
            }
            // not moved further down
            if (maxIndex != index) {
                swap(index, maxIndex);
                index = maxIndex;
            } else {
                return;
            }

        }

    }

}
