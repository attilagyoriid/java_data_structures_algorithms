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

    public Node remove2(Node head, int value) {
        Node dummy = new Node(Integer.MIN_VALUE); // dummy is the previous, the first pointer
        dummy.setNext(head);
        Node previous = dummy;
        Node current = head;
        while (current != null) {
            Node next = current.next; // store because it will be overwritten
            if (current.value == value) { //remove the current node
                previous.next = next; // not point to current but current.next so we delete the current

            } else { // not remove the current value
                previous = current;
            }
            current = next;
        }

        return dummy.next;
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

    public Node reverse(Node tempHead) {
        Node temp = tempHead;
        Node after = temp.next;
        Node before = null;
        while (temp !=null) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
        return before; //current head
    }

    public Node reverse2(Node head) { // Time Complexity O(n) Space O(1)
        Node current = head;
        Node previous = null;
        Node tmpNext = null;
        while (current != null) {
            // reverse pointers
            tmpNext = current.next;
            current.next = previous; // change the direction
            previous = current; // shift pointers
            current = tmpNext; //current.next;
        }

        return previous; //current head
    }

    public Node reverseRecursive(Node head) { // Time Complexity O(n) Space O(n)
        if (head == null) { // recursive
            return null;
        }
        Node newHead = head;
        if (head.next != null) {
            newHead = reverseRecursive(head.next);
            head.next.next = head; // reverse the link
        }
        head.next = null;
        return newHead;
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
     * <p>
     * Check if head is null. If it is, the list is empty, so simply return.
     * <p>
     * Create two dummy nodes, dummy1 and dummy2, and initialize two pointers, prev1 and prev2, pointing to these dummy nodes respectively.
     * <p>
     * Initialize a pointer current pointing to the head of the list.
     * <p>
     * Start a while loop that continues until current is null:
     * <p>
     * Check if the value of the current node is less than the given value x. i. If it is, update the next pointer of prev1 to point to current,
     * and update prev1 to point to current.
     * <p>
     * If it is not, update the next pointer of prev2 to point to current, and update prev2 to point to current.
     * <p>
     * Move current one step ahead (i.e., current = current.next).
     * <p>
     * Set the next pointer of prev2 to null, which terminates the second partition.
     * <p>
     * Set the next pointer of prev1 to the first node of the second partition (i.e., prev1.next = dummy2.next).
     * <p>
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
     * <p>
     * Create an empty HashSet called values to store the unique node values encountered in the linked list.
     * <p>
     * Initialize two pointers: previous set to null, and current pointing to the head of the list.
     * <p>
     * Start a while loop that continues until current is null: a. Check if values contains the value of the current node. i.
     * If it does, update the next pointer of the previous node to skip the current node (i.e., previous.next = current.next),
     * and decrement the list length by 1. b. If it does not, add the value of the current node to the values set and update the previous pointer
     * to point to the current node. c. Move current one step ahead (i.e., current = current.next).
     * <p>
     * When the while loop ends, all duplicate nodes will have been removed from the list.
     * <p>
     * <p>
     * <p>
     * This algorithm uses a HashSet to keep track of unique values in the linked list and
     * removes duplicates by updating the next pointers of the nodes as needed.
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * Pseudo Code (for solution that does not use a set):
     * <p>
     * Initialize a pointer current pointing to the head of the list.
     * <p>
     * Start an outer while loop that continues until current is null: a. Initialize a pointer runner pointing to the current node. b.
     * Start an inner while loop that continues until runner.next is null: i.
     * Check if the value of the runner.next node is equal to the value of the current node.
     * 1. If it is, update the next pointer of the runner node to skip the duplicate node (i.e., runner.next = runner.next.next),
     * and decrement the list length by 1. ii. If it is not, move the runner pointer one step ahead (i.e., runner = runner.next).
     * c. Move current one step ahead (i.e., current = current.next).
     * <p>
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
     *
     * @return decimal
     * <p>
     * 1. Start with a variable called 'num' and set it to 0.
     * <p>
     * This will store our resulting decimal number.
     * <p>
     * <p>
     * <p>
     * 2. Create a pointer called 'current' and set it to point to the start of the linked list (the head).
     * <p>
     * <p>
     * <p>
     * 3. Begin a loop. Continue this loop as long as 'current' is not pointing to nothing (i.e., as long as we haven't reached the end of the list).
     * <p>
     * <p>
     * <p>
     * a. Inside the loop, the first step is to double the current value of 'num'.
     * <p>
     * This is like making space for the next binary digit.
     * <p>
     * Imagine we are reading a binary number from left to right.
     * <p>
     * Each time we move to the next position, we're shifting everything
     * <p>
     * to the left, which is equivalent to doubling in the binary system.
     * <p>
     * <p>
     * <p>
     * b. Add the value of the node that 'current' is pointing to, to 'num'.
     * <p>
     * This value will be either 0 or 1 since it's a binary digit.
     * <p>
     * Now 'num' contains the accumulated value up to the current binary digit.
     * <p>
     * <p>
     * <p>
     * c. Move the 'current' pointer to the next node in the list to continue
     * <p>
     * the loop for the next binary digit.
     * <p>
     * <p>
     * <p>
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

    /**
     * Check if a valid palindrome stored in linked list
     *
     * @return true if palindrome
     */
    public boolean isValidPalindrome() {

        Node fast = head;
        Node slow = head;

        // find the middle point
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the second half
        Node left = head;
        Node right = reverse(slow);

        // check if palindrome
        while(right !=null) {
            if (left.getValue() != right.getValue()) {
                return false;
            }
            left = left.next;
            right = right.next;

        }
        return true;
    }

    /**
     *
     * @param startIndex
     * @param endIndex
     *
     *
     * Check if the head of the list is null.
     *
     * If the list is empty, there is nothing to reverse. Return immediately (do nothing).
     *
     * Create a dummyNode with value 0.
     *
     * This node serves as a placeholder to simplify operations involving the list head.
     *
     * Set the next pointer of dummyNode to point to the head of the list.
     *
     * Initialize a variable previousNode and set it to dummyNode.
     *
     * previousNode will track the node right before the segment we want to reverse.
     *
     * Move previousNode forward startIndex steps to position it just before the start of the segment to reverse.
     *
     * Use a loop with an index i going from 0 to startIndex.
     *
     * Set a currentNode variable to point to the next node after previousNode.
     *
     * currentNode will be the first node of the segment to be reversed.
     *
     * Now we're ready to reverse the segment.
     *
     * Perform the following steps endIndex - startIndex times:
     *
     * Set a nodeToMove variable to point to the next node after currentNode. This is the node
     * we will "cut" from the segment and "paste" to the front of the segment.
     *
     * Update currentNode.next to skip over nodeToMove and point to the node right after nodeToMove.
     *
     * Set the next pointer of nodeToMove to point to the node at the front of the segment. This is the node that previousNode.next is pointing to.
     *
     * Update previousNode.next to point to nodeToMove. nodeToMove has now been moved to the front of the segment.
     *
     * After the loop, the segment between startIndex and endIndex is reversed.
     *
     * Update the head of the list to point to the actual first node (not dummyNode).
     *
     * Set head to point to dummyNode.next.
     *
     *
     *
     * Example in plain English:
     *
     * Imagine you have a deck of cards numbered from 1 to 10 in order. Now, I want you to reverse the cards between positions 3 and 7.
     *
     * Here's how you can do it:
     *
     * Find the 3rd Card: Locate the card at the 3rd position. Let's call this card the "previousNode card" and place it on the table.
     *
     * Identify the Starting Card: Look at the next card in line. Name this the "currentNode card." This card marks the beginning of the section to reverse.
     *
     * Prepare for the Magic Trick: Get ready to perform a magic trick on the next set of cards.
     *
     * Select Next Card: Focus on the "currentNode card." Pick up the card immediately after it, and call it the "nodeToMove card."
     *
     * Rearrange Cards: Move the "currentNode card" so that it sits behind the "nodeToMove card."
     *
     * Place the Card: Lay the "nodeToMove card" down on the table next to the "previousNode card." Now, the "nodeToMove card" has moved to the front.
     *
     * Repeat the Process: Continue this process until you reach the card at the 7th position. By the end, the cards between the 3rd and 7th positions should be in reverse order.
     */
    public void reverseBetween(int startIndex, int endIndex) {
        if (head == null) return;

        Node dummyNode = new Node(0);
        dummyNode.next = head;
        Node previousNode = dummyNode;

        for (int i = 0; i < startIndex; i++) {
            previousNode = previousNode.next;
        }

        Node currentNode = previousNode.next;

        for (int i = 0; i < endIndex - startIndex; i++) {
            Node nodeToMove = currentNode.next;
            currentNode.next = nodeToMove.next;
            nodeToMove.next = previousNode.next;
            previousNode.next = nodeToMove;
        }

        head = dummyNode.next;
    }

}
