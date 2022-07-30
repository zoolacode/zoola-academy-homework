package com.zoolatech.lecture4.tasks._2;

/**
 * Create a class that represents a binary search tree. The tree should
 * have a reference to the root node. Each node stores an integer value
 * and has references to the left and right children nodes. The tree
 * should also have a method that accepts a value and adds it to the tree.
 */

public class Task2 {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(8);
        binaryTree.insert(8);
        binaryTree.insert(3);
        binaryTree.insert(2);
        binaryTree.insert(1);
        binaryTree.insert(15);
        binaryTree.insert(10);
        binaryTree.insert(20);
    }
}