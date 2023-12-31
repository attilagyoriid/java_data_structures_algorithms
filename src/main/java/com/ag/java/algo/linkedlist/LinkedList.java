package com.ag.java.algo.linkedlist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;


    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public List<Integer> getAsList() {
        List list = new ArrayList<>();
        Node temp = head;
        while (temp != null) {
            list.add(temp.value);
            temp = temp.next;
        }
        return list;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }


    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast() {
        if (length == 0) return null;
        Node temp = head;
        Node pre = head;
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public void makeEmpty() {
        head = null;
        tail = null;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        if (length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) {
            tail = null;
        }
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) return null;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) return false;
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if (index == length - 1) return removeLast();

        Node prev = get(index - 1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;
        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }


    /**
     * Implement a method called findMiddleNode that returns the middle node of the linked list.
     * In this problem,
     * we should use the slow and fast pointer technique
     * (also known as Floyd's Tortoise and Hare algorithm)
     * to find the middle element of the linked list
     * efficiently.
     */
    public Node findMiddleNode() {
        if (null == head) {
            return null;
        }

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * Detect cycle or loop
     */
    public boolean hasLoop() {

        if (null == head) {
            return false;
        }

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }


        return false;
    }

    /**
     * findKthFromEnd that returns the k-th node from the end of the list.
     */
    public Node findKthFromEnd(int k) {
        Node slow = head;
        Node fast = head;

        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    /**
     * Partition List
     * rearrange the linked list such that
     * all nodes with a value less than x come before all nodes with a value greater than or equal to x
     */
    public void partitionList(int x) {
        if (head == null) return;

        Node left = new Node(0);
        Node right = new Node(0);
        Node leftTail = left;
        Node rightTail = right;
        Node current = head;

        while (current != null) {
            if (current.value < x) {
                leftTail.next = current;
                leftTail = current;
            } else {
                rightTail.next = current;
                rightTail = current;
            }
            current = current.next;
        }

        rightTail.next = null;
        leftTail.next = right.next;

        head = left.next;
    }

    /**
     * Swap every two adjacent nodes and return its head
     */
    public Node swapPairs() {

        if (length < 2) {
            return head;
        }

        Node dummy = new Node(0);
        dummy.next = head;
        Node previous = dummy;
        Node current = head;

        while (current != null && current.next != null) {
            Node nextPair = current.next.next;
            Node second = current.next;

            second.next = current;
            current.next = nextPair;
            previous.next = second;

            previous = current;
            current = nextPair;
        }
        this.head = dummy.next;
        return this.head;


    }

    /**
     * Remove Duplicates Linked List
     * You are given a singly linked list that contains integer values, where some of these values may be duplicated.
     */
    public void removeDuplicates() {
        Set<Integer> values = new HashSet<>();
        Node previous = null;
        Node current = head;
        while (current != null) {
            if (values.contains(current.value)) {
                previous.next = current.next;
                length -= 1;
            } else {
                values.add(current.value);
                previous = current;
            }
            current = current.next;
        }
    }




}
