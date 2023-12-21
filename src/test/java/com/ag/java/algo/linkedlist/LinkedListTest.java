package com.ag.java.algo.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

    /**
     * Detect cycle or loop
     */
    @Test
    void hasLoop_true() {
        LinkedList myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);

        // create a loop by connecting the tail to the second node
        myLinkedList.getTail().setNext(myLinkedList.getHead().getNext());
        Assertions.assertTrue(myLinkedList.hasLoop());
    }

    @Test
    void hasLoop_empty_false() {
        LinkedList myLinkedList = new LinkedList(1);
        myLinkedList.makeEmpty();
        Assertions.assertFalse(myLinkedList.hasLoop());
    }

    @Test
    void hasLoop_false() {
        LinkedList myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);
        Assertions.assertFalse(myLinkedList.hasLoop());
    }

    /**
     * findKthFromEnd that returns the k-th node from the end of the list.
     */
    @Test
    void findKthFromEnd_happy() {
        LinkedList myList = new LinkedList(1);
        myList.append(2);
        myList.append(3);
        myList.append(4);
        myList.append(5);
        Assertions.assertEquals(4, myList.findKthFromEnd(2).value);
    }

    @Test
    void findKthFromEnd_index_out() {
        LinkedList myList = new LinkedList(1);
        myList.append(2);
        myList.append(3);
        myList.append(4);
        myList.append(5);
        Assertions.assertNull(myList.findKthFromEnd(6));
    }

    @Test
    void findKthFromEnd_empty() {
        LinkedList myList = new LinkedList(1);
        myList.makeEmpty();
        Assertions.assertNull(myList.findKthFromEnd(6));
    }
}