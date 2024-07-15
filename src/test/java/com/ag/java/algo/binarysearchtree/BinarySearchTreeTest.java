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


    @Test
    void isSameTree() {
        Node root1 = new Node(54);
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
        root1.setLeft(left);
        root1.setRight(right);
        BinarySearchTree binarySearchTree = new BinarySearchTree(root1);
        Node root2 = root1;

        Assertions.assertTrue(binarySearchTree.isSameTree(root2));

    }
    @Test
    void isSameTree_not_same() {
        Node root1 = new Node(54);
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
        root1.setLeft(left);
        root1.setRight(right);
        BinarySearchTree binarySearchTree = new BinarySearchTree(root1);

        Node root2 = new Node(54);
        Node left2 = new Node(40);
        Node right2 = new Node(60);
        Node leftLeft2 = new Node(21);
        Node leftRight2 = new Node(51);
        Node rightLeft2 = new Node(59);
        Node rightRight2 = new Node(80);


        left2.setLeft(leftLeft2);
        left2.setRight(leftRight2);
        right2.setLeft(rightLeft2);
        right2.setRight(rightRight2);
        root2.setLeft(left2);
        root2.setRight(right2);

        Assertions.assertFalse(binarySearchTree.isSameTree(root2));

    }
}