package com.zoolatech.lecture4.tasks._2;

public class BinarySearchTree {
    private Node rootNode;
    public BinarySearchTree () {
        rootNode = null;
    }

    private static class Node {
        private final int value;
        private Node leftChild;
        private Node rightChild;
        public Node (int value) {
            this.value = value;
            leftChild = null;
            rightChild = null;
        }
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.value) {
            current.leftChild = addRecursive(current.leftChild, value);
        } else if (value > current.value) {
            current.rightChild = addRecursive(current.rightChild, value);
        }
        return current;
    }
    public void add(int value) {
        rootNode = addRecursive(rootNode, value);
    }

}
