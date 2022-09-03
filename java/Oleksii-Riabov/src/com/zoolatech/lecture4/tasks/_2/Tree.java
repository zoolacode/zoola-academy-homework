package com.zoolatech.lecture4.tasks._2;

public class Tree {

    public static class Node {
        int value;
        Node leftNode;
        Node rightNode;

        Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.leftNode = addRecursive(current.leftNode, value);
        } else if (value > current.value) {
            current.rightNode = addRecursive(current.rightNode, value);
        }

        return current;
    }

    void inorder() {
        inorderRecursive(root);
    }

    void inorderRecursive(Node root) {
        if (root != null) {
            inorderRecursive(root.leftNode);
            System.out.print(root.value + " ");
            inorderRecursive(root.rightNode);
        }
    }
}
