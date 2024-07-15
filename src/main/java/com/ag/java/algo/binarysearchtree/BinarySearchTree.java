package com.ag.java.algo.binarysearchtree;

import java.util.*;

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

    public List<Integer> breathFirstSearchLevelOrder() {
        List<Integer> result = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int queueLength = queue.size();
            for (int i = 0; i < queueLength; i++) {
                Node currentRoot = queue.remove();
                if (currentRoot != null) {
                    result.add(currentRoot.getValue());
                    if (currentRoot.getLeft()!=null) {
                        queue.add(currentRoot.getLeft());
                    }
                    if (currentRoot.getRight()!=null) {
                        queue.add(currentRoot.getRight());
                    }
                }

            }
        }

        return result;
    }

    public boolean isSameTree(Node rootToCompare) {

        return isSameTree(this.root, rootToCompare);

    }
    private boolean isSameTree(Node currentRoot, Node rootToCompare) {
        if (currentRoot == null && rootToCompare == null) {
            return true;
        }
        if ((currentRoot == null || rootToCompare == null) || (currentRoot.getValue() != rootToCompare.getValue())) {
            return false;
        }
        return isSameTree(currentRoot.getLeft(), rootToCompare.getLeft()) && isSameTree(currentRoot.getRight(), rootToCompare.getRight());

    }


    /**
     * Maximum Depth
     *
     * @return
     */
    public int maxDepth() {
        if (root == null) {
            return 0;
        }
        return maxDepth(root);
    }

    public int maxDepthBFS() {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        Deque<Node> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int actualSize = deque.size();
            for (int i = 0; i < actualSize; i++) {
                Node node = deque.pollLast();
                if (node.getLeft() != null) {
                    deque.addLast(node.getLeft());
                }
                if (node.getRight() != null) {
                    deque.addLast(node.getRight());
                }
            }
            depth += 1;
        }
        return depth;
    }


    private int maxDepth(Node node) {
        if (node == null) {
            return 0;
        }

        int left = maxDepth(node.getLeft());
        int right = maxDepth(node.getRight());
        return Math.max(left, right) + 1;
    }

    private void depthFirstSearchInOrder(Node root, List<Integer> inOrderTraversList) {

        if (root == null) {
            return;
        }
        if (root.getLeft() != null) {
            depthFirstSearchInOrder(root.getLeft(), inOrderTraversList);
        }
        System.out.printf(root.getValue() + "->");
        inOrderTraversList.add(root.getValue());
        if (root.getRight() != null) {
            depthFirstSearchInOrder(root.getRight(), inOrderTraversList);
        }
    }


}
