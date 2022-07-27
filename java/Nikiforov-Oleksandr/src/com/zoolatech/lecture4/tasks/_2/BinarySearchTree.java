package com.zoolatech.lecture4.tasks._2;

public class BinarySearchTree {
    static class Node {
        int key;
        Node left, right;

        public Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    private Node root;

    public BinarySearchTree(int value) {
        root = new Node(value);
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    public Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        return root;
    }

    void inorder() {
        inorderRecorder(root);
    }

    void inorderRecorder(Node root) {
        if (root != null) {
            inorderRecorder(root.left);
            System.out.println(root.key);
            inorderRecorder(root.right);
        }
    }
}
