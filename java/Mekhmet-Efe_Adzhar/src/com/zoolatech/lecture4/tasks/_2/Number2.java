package com.zoolatech.lecture4.tasks._2;

/*
Create a class that represents a binary search tree.
The tree should have a reference to the root node.
Each node stores an integer value and has references to the left and right children nodes.
The tree should also have a method that accepts a value and adds it to the tree.
 */

public class Number2 {
    public static void main(String[] args) {
        Node node = new Node(12);
        BinaryTree binaryTree = new BinaryTree(node);
        binaryTree.insert(node, 15);
        binaryTree.insert(node, 10);
        binaryTree.insert(node, 20);
        binaryTree.insert(node, 1);
        binaryTree.insert(node, 13);
        binaryTree.delete(node, 13);
        binaryTree.delete(node, 10);
        binaryTree.order(node);
        System.out.println("ROOT NODE: " + binaryTree.getRootNodeValue());
    }
}

record BinaryTree(Node rootNode) {

    public int getRootNodeValue() {
        return rootNode.getValue();
    }

    public Node insert(Node node, int value) {
        if (node == null) {
            node = new Node(value);
        } else if (value <= node.getValue()) {
            node.setLeftChild(insert(node.getLeftChild(), value));
        } else {
            node.setRightChild(insert(node.getRightChild(), value));
        }
        return node;
    }

    public void order(Node node) {
        if (node != null) {
            order(node.getLeftChild());
            System.out.println(node.getValue());
            order(node.getRightChild());
        }
    }

    public Node delete(Node node, int value) {
        if (value < node.getValue()) {
            node.setLeftChild(delete(node.getLeftChild(), value));
        } else if (value > node.getValue()) {
            node.setRightChild(delete(node.getRightChild(), value));
        } else {
            if (node.getRightChild() == null && node.getLeftChild() == null) {
                node = null;
            } else if (node.getRightChild() == null) {
                node = node.getLeftChild();
            } else if (node.getLeftChild() == null) {
                node = node.getRightChild();
            } else {
                Node temp = node.getRightChild();
                node.setValue(temp.getValue());
                node.setRightChild(delete(node.getRightChild(), temp.getValue()));
            }
        }
        return node;
    }
}

class Node {
    private int value;
    private Node leftChild;
    private Node rightChild;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
}