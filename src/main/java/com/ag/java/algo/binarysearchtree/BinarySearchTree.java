package com.ag.java.algo.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

    private Node root;

    public BinarySearchTree(Node root) {
        this.root = root;
    }
    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (newNode.getValue() == temp.getValue()) return false;
            if (newNode.getValue() < temp.getValue()) {
                if (temp.getLeft() == null) {
                    temp.setLeft(newNode);
                    return true;
                }
                temp = temp.getLeft();
            } else {
                if (temp.getRight() == null) {
                   temp.setRight(newNode);
                   return true;
                }
                temp = temp.getRight();
            }
        }
    }

    public boolean contains(int value) {
        if (root == null) return false;
        Node temp = root;
        while (temp != null) {
            if (value < temp.getValue()) {
                temp = temp.getLeft();
            } else if (value > temp.getValue()) {
                temp = temp.getRight();
            } else {
                return true;
            }
        }
        return false;
    }
    public List<Integer> depthFirstSearchInOrder() {
        ArrayList<Integer> inOrderTraversList = new ArrayList<>();
        depthFirstSearchInOrder(root, inOrderTraversList);
        return inOrderTraversList;
    }

    /**
     * Maximum Depth
     * @return
     */
    public int maxDepth() {
        if (root == null) {
            return 0;
        }
        return maxDepth(root);
    }

    private int maxDepth(Node node) {
        if (node == null) {
            return 0;
        }

        int left = maxDepth(node.getLeft());
        int right = maxDepth(node.getRight());
        return Math.max(left,right) + 1;
    }

    private void depthFirstSearchInOrder(Node root, List<Integer> inOrderTraversList) {

        if (root == null) {
            return;
        }
        if (root.getLeft() != null) {
            depthFirstSearchInOrder(root.getLeft(),inOrderTraversList);
        }
        System.out.printf(root.getValue() + "->");
        inOrderTraversList.add(root.getValue());
        if (root.getRight() != null) {
            depthFirstSearchInOrder(root.getRight(),inOrderTraversList);
        }
    }
}
