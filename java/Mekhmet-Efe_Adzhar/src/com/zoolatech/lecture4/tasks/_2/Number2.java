package com.zoolatech.lecture4.tasks._2;

/*
Create a class that represents a binary search tree.
The tree should have a reference to the root node.
Each node stores an integer value and has references to the left and right children nodes.
The tree should also have a method that accepts a value and adds it to the tree.
 */

public class Number2 {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.Node node = binaryTree.new Node(12);
        binaryTree.insert(node, 15);
        binaryTree.insert(node, 10);
        binaryTree.insert(node, 20);
        binaryTree.insert(node, 1);
        binaryTree.insert(node, 13);
        binaryTree.delete(node, 13);
        binaryTree.delete(node, 10);
        binaryTree.order(node);
    }
}

class BinaryTree {

    class Node {
        int value;
        Node leftChild;
        Node rightChild;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node insert(Node node, int value) {
        if (node == null) {
            node = new Node(value);
        } else if (value <= node.value) {
            node.leftChild = insert(node.leftChild, value);
        } else {
            node.rightChild = insert(node.rightChild, value);
        }
        return node;
    }

    void order(Node node) {
        if (node != null) {
            order(node.leftChild);
            System.out.println(node.value);
            order(node.rightChild);
        }
    }

    public Node delete(Node node, int value) {
        if (node == null) {
            node = new Node(value);
        }
        if (value < node.value) {
            node.leftChild = delete(node.leftChild, value);
        } else if (value > node.value) {
            node.rightChild = delete(node.rightChild, value);
        } else {
            if (node.rightChild == null && node.leftChild == null) {
                node = null;
            } else if (node.rightChild == null) {
                node = node.leftChild;
            } else if (node.leftChild == null) {
                node = node.rightChild;
            } else {
                Node temp = node.rightChild;
                node.value = temp.value;
                node.rightChild = delete(node.rightChild, temp.value);
            }
        }
        return node;
    }
}