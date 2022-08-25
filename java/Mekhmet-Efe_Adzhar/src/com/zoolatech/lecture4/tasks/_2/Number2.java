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
        binaryTree.insert(12);
        binaryTree.insert(15);
        binaryTree.insert(10);
        binaryTree.insert(20);
        binaryTree.insert(1);
        binaryTree.insert(13);
        binaryTree.delete(13);
        binaryTree.delete(10);
        binaryTree.order();
        System.out.println("Root node: " + binaryTree.getRootNodeValue());
    }
}

class BinaryTree {
   private Node rootNode;

    private static class Node {
        int value;
        Node leftChild;
        Node rightChild;

        public Node(int value) {
            this.value = value;
        }
    }

    public int getRootNodeValue() {
        return rootNode.value;
    }

    public void insert(int value) {
        rootNode = insertNode(rootNode, value);
    }

    public void delete(int value) {
        rootNode = deleteNode(rootNode, value);
    }

    public void order() {
      orderNode(rootNode);
    }

    private Node insertNode(Node node, int value) {
        if (node == null) {
            node = new Node(value);
        } else if (value <= node.value) {
            node.leftChild = insertNode(node.leftChild, value);
        } else {
            node.rightChild = insertNode(node.rightChild, value);
        }
        return node;
    }

    private void orderNode(Node node) {
        if (node != null) {
            orderNode(node.leftChild);
            System.out.println(node.value);
            orderNode(node.rightChild);
        }
    }

    private Node deleteNode(Node node, int value) {
        if (node == null) {
            node = new Node(value);
        }
        if (value < node.value) {
            node.leftChild = deleteNode(node.leftChild, value);
        } else if (value > node.value) {
            node.rightChild = deleteNode(node.rightChild, value);
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
                node.rightChild = deleteNode(node.rightChild, temp.value);
            }
        }
        return node;
    }
}