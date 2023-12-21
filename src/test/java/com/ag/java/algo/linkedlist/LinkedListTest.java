package com.ag.java.algo.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    /**
     * Implement a method called findMiddleNode that returns the middle node of the linked list.
     * In this problem,
     * we should use the slow and fast pointer technique
     * (also known as Floyd's Tortoise and Hare algorithm)
     * to find the middle element of the linked list
     * efficiently.
     */
    @Test
    void findMiddleNode_happy() {
        LinkedList myList = new LinkedList(1);
        myList.append(2);
        myList.append(3);
        myList.append(4);
        myList.append(5);
        Node middleNode = myList.findMiddleNode();
        Assertions.assertEquals(3, middleNode.value);
    }

    @Test
    void findMiddleNode_empty() {
        LinkedList myList = new LinkedList(1);
        myList.makeEmpty();
        Node middleNode = myList.findMiddleNode();
        Assertions.assertNull(middleNode);
    }

    @Test
    void findMiddleNode_one_item() {
        LinkedList myList = new LinkedList(1);
        Node middleNode = myList.findMiddleNode();
        Assertions.assertEquals(1, middleNode.value);
    }
}