package com.ag.java.algo.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

    private Node root;

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    public List<Integer> depthFirstSearchInOrder() {
        ArrayList<Integer> inOrderTraversList = new ArrayList<>();
        depthFirstSearchInOrder(root, inOrderTraversList);
        return inOrderTraversList;
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
