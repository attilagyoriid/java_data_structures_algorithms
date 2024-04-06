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
     *
     * Check if head is null. If it is, the list is empty, so simply return.
     *
     * Create two dummy nodes, dummy1 and dummy2, and initialize two pointers, prev1 and prev2, pointing to these dummy nodes respectively.
     *
     * Initialize a pointer current pointing to the head of the list.
     *
     * Start a while loop that continues until current is null:
     *
     * Check if the value of the current node is less than the given value x. i. If it is, update the next pointer of prev1 to point to current,
     * and update prev1 to point to current.
     *
     * If it is not, update the next pointer of prev2 to point to current, and update prev2 to point to current.
     *
     * Move current one step ahead (i.e., current = current.next).
     *
     * Set the next pointer of prev2 to null, which terminates the second partition.
     *
     * Set the next pointer of prev1 to the first node of the second partition (i.e., prev1.next = dummy2.next).
     *
     * Update the head of the list to the first node of the first partition (i.e., head = dummy1.next).
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
                leftTail = leftTail.next;
            } else {
                rightTail.next = current;
                rightTail = rightTail.next;
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
     * Pseudo Code (for solution that uses a set):
     *
     * Create an empty HashSet called values to store the unique node values encountered in the linked list.
     *
     * Initialize two pointers: previous set to null, and current pointing to the head of the list.
     *
     * Start a while loop that continues until current is null: a. Check if values contains the value of the current node. i.
     * If it does, update the next pointer of the previous node to skip the current node (i.e., previous.next = current.next),
     * and decrement the list length by 1. b. If it does not, add the value of the current node to the values set and update the previous pointer
     * to point to the current node. c. Move current one step ahead (i.e., current = current.next).
     *
     * When the while loop ends, all duplicate nodes will have been removed from the list.
     *
     *
     *
     * This algorithm uses a HashSet to keep track of unique values in the linked list and
     * removes duplicates by updating the next pointers of the nodes as needed.
     *
     *
     *
     *
     *
     * Pseudo Code (for solution that does not use a set):
     *
     * Initialize a pointer current pointing to the head of the list.
     *
     * Start an outer while loop that continues until current is null: a. Initialize a pointer runner pointing to the current node. b.
     * Start an inner while loop that continues until runner.next is null: i.
     * Check if the value of the runner.next node is equal to the value of the current node.
     * 1. If it is, update the next pointer of the runner node to skip the duplicate node (i.e., runner.next = runner.next.next),
     * and decrement the list length by 1. ii. If it is not, move the runner pointer one step ahead (i.e., runner = runner.next).
     * c. Move current one step ahead (i.e., current = current.next).
     *
     * When the outer while loop ends, all duplicate nodes will have been removed from the list.
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

    /**
     * Convert binary to decimal
     * @return decimal
     *
     * 1. Start with a variable called 'num' and set it to 0.
     *
     *    This will store our resulting decimal number.
     *
     *
     *
     * 2. Create a pointer called 'current' and set it to point to the start of the linked list (the head).
     *
     *
     *
     * 3. Begin a loop. Continue this loop as long as 'current' is not pointing to nothing (i.e., as long as we haven't reached the end of the list).
     *
     *
     *
     *    a. Inside the loop, the first step is to double the current value of 'num'.
     *
     *       This is like making space for the next binary digit.
     *
     *       Imagine we are reading a binary number from left to right.
     *
     *       Each time we move to the next position, we're shifting everything
     *
     *       to the left, which is equivalent to doubling in the binary system.
     *
     *
     *
     *    b. Add the value of the node that 'current' is pointing to, to 'num'.
     *
     *       This value will be either 0 or 1 since it's a binary digit.
     *
     *       Now 'num' contains the accumulated value up to the current binary digit.
     *
     *
     *
     *    c. Move the 'current' pointer to the next node in the list to continue
     *
     *       the loop for the next binary digit.
     *
     *
     *
     * 4. Once the loop finishes (we've processed all binary digits), return the value of 'num' which now contains
     * the decimal representation of the binary number in the linked list.
     */
    public int binaryToDecimal() {
        int num = 0;
        Node current = head;
        while (current != null) {
            num = num * 2 + current.value;
            current = current.next;
        }
        return num;
    }



}
