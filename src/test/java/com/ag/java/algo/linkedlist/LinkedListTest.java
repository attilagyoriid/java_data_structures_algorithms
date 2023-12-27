package com.ag.java.algo.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    void printList() {
        LinkedList myList = new LinkedList(1);
        myList.append(2);
        myList.append(3);
        myList.append(4);
        myList.append(5);
        myList.printList();
    }

    @Test
    void getHead() {
        LinkedList myList = new LinkedList(1);
        myList.append(2);
        myList.append(3);
        myList.append(4);
        myList.append(5);
        Assertions.assertEquals(1, myList.getHead().getValue());
    }

    @Test
    void getTail() {
        LinkedList myList = new LinkedList(1);
        myList.append(2);
        myList.append(3);
        myList.append(4);
        myList.append(5);
        Assertions.assertEquals(5, myList.getTail().getValue());
    }

    @Test
    void getLength() {
        LinkedList myList = new LinkedList(1);
        myList.append(2);
        myList.append(3);
        myList.append(4);
        myList.append(5);
        Assertions.assertEquals(5, myList.getLength());
    }

    @Test
    void append() {
        LinkedList myList = new LinkedList(1);
        myList.append(2);
        myList.append(3);
        myList.append(4);
        Assertions.assertEquals(4, myList.getTail().getValue());
        myList.append(5);
        Assertions.assertEquals(5, myList.getTail().getValue());
    }

    @Test
    void removeLast() {
        LinkedList myList = new LinkedList(1);
        myList.append(2);
        myList.append(3);
        myList.append(4);
        Assertions.assertEquals(4, myList.getTail().getValue());
        Assertions.assertEquals(4, myList.removeLast().getValue());
        Assertions.assertEquals(3, myList.getTail().getValue());

    }

    @Test
    void makeEmpty() {
        LinkedList myList = new LinkedList(1);
        Assertions.assertEquals(1, myList.getHead().getValue());
        myList.makeEmpty();
        Assertions.assertNull(myList.getHead());
        Assertions.assertNull(myList.getTail());
    }

    @Test
    void prepend() {
        LinkedList myList = new LinkedList(1);
        Assertions.assertEquals(1, myList.getHead().getValue());
        myList.prepend(2);
        Assertions.assertEquals(2, myList.getHead().getValue());
    }

    @Test
    void removeFirst() {
        LinkedList myList = new LinkedList(1);
        myList.append(2);
        myList.append(3);
        Assertions.assertEquals(1, myList.getHead().getValue());
        myList.removeFirst();
        Assertions.assertEquals(2, myList.getHead().getValue());
    }

    @Test
    void get() {
        LinkedList myList = new LinkedList(1);
        myList.append(2);
        Assertions.assertEquals(2, myList.get(1).getValue());
    }

    @Test
    void set() {
        LinkedList myList = new LinkedList(1);
        myList.append(2);
        Assertions.assertTrue( myList.set(1,8));
        Assertions.assertEquals(8, myList.get(1).getValue());
    }

    @Test
    void insert() {
        LinkedList myList = new LinkedList(1);
        myList.append(9);
        Assertions.assertTrue( myList.insert(1,8));
        Assertions.assertEquals(8, myList.get(1).getValue());
        Assertions.assertEquals(9, myList.get(2).getValue());
    }

    @Test
    void remove() {
        LinkedList myList = new LinkedList(1);
        myList.append(9);
        Assertions.assertEquals(2, myList.getLength());
        myList.remove(1);
        Assertions.assertEquals(1, myList.getLength());
    }

    @Test
    void reverse() {
        LinkedList myList = new LinkedList(1);
        myList.append(9);
        myList.reverse();
        Assertions.assertEquals(9, myList.get(0).getValue());
        Assertions.assertEquals(1, myList.get(1).getValue());
    }

    /**
     * Partition List
     * rearrange the linked list such that
     * all nodes with a value less than x come before all nodes with a value greater than or equal to x
     */
    @Test
    void partitionList() {
        LinkedList ll = new LinkedList(3);
        ll.append(5);
        ll.append(8);
        ll.append(10);
        ll.append(2);
        ll.append(1);
        ll.partitionList(5);
        Assertions.assertIterableEquals(List.of(3,2,1,5,8,10),ll.getAsList());
    }

    /**
     * Swap every two adjacent nodes and return its head
     */
    @Test
    void swapPairs() {
        LinkedList ll = new LinkedList(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.append(5);
        ll.append(6);
        ll.swapPairs();
        ll.printList();
        Assertions.assertIterableEquals(List.of(2,1,4,3, 6, 5),ll.getAsList());
    }
}