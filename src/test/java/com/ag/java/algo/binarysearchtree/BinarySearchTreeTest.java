package com.ag.java.algo.binarysearchtree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @Test
    void depthFirstSearchInOrder() {

        Node root = new Node(54);
        Node left = new Node(40);
        Node right = new Node(60);
        Node leftLeft = new Node(21);
        Node leftRight = new Node(45);
        Node rightLeft = new Node(59);
        Node rightRight = new Node(75);


        left.setLeft(leftLeft);
        left.setRight(leftRight);
        right.setLeft(rightLeft);
        right.setRight(rightRight);
        root.setLeft(left);
        root.setRight(right);
        BinarySearchTree binarySearchTree = new BinarySearchTree(root);
        Assertions.assertIterableEquals(Arrays.asList(21, 40, 45, 54, 59, 60, 75),binarySearchTree.depthFirstSearchInOrder());
    }

    @Test
    void breathFirstSearchLevelOrder() {
        Node root = new Node(54);
        Node left = new Node(40);
        Node right = new Node(60);
        Node leftLeft = new Node(21);
        Node leftRight = new Node(45);
        Node rightLeft = new Node(59);
        Node rightRight = new Node(75);


        left.setLeft(leftLeft);
        left.setRight(leftRight);
        right.setLeft(rightLeft);
        right.setRight(rightRight);
        root.setLeft(left);
        root.setRight(right);
        BinarySearchTree binarySearchTree = new BinarySearchTree(root);
        Assertions.assertIterableEquals(Arrays.asList(54,40,60,21,45,59,75),binarySearchTree.breathFirstSearchLevelOrder());

    }

    @Test
    void maxDepth() {
        Node root = new Node(54);
        Node left = new Node(40);
        Node right = new Node(60);
        Node leftLeft = new Node(21);
        Node leftRight = new Node(45);
        Node rightLeft = new Node(59);
        Node rightRight = new Node(75);


        left.setLeft(leftLeft);
        left.setRight(leftRight);
        right.setLeft(rightLeft);
        right.setRight(rightRight);
        root.setLeft(left);
        root.setRight(right);
        BinarySearchTree binarySearchTree = new BinarySearchTree(root);
        Assertions.assertEquals(3,binarySearchTree.maxDepth());
    }

    @Test
    void maxDepthBFS() {
        Node root = new Node(54);
        Node left = new Node(40);
        Node right = new Node(60);
        Node leftLeft = new Node(21);
        Node leftRight = new Node(45);
        Node rightLeft = new Node(59);
        Node rightRight = new Node(75);


        left.setLeft(leftLeft);
        left.setRight(leftRight);
        right.setLeft(rightLeft);
        right.setRight(rightRight);
        root.setLeft(left);
        root.setRight(right);
        BinarySearchTree binarySearchTree = new BinarySearchTree(root);
        Assertions.assertEquals(3,binarySearchTree.maxDepthBFS());
    }


}