package com.zoolatech.lecture4.tasks._2;

/**
 * Create a class that represents a binary search tree (https://en.wikipedia.org/wiki/Binary_search_tree).
 * The tree should have a reference to the root node. Each node stores an integer value and has references
 * to the left and right children nodes. The tree should also have a method that accepts a value and adds
 * it to the tree.
 */

public class Task2 {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(10);
        bst.add(20);
        bst.add(5);
        bst.add(3);
        bst.add(40);
        bst.add(15);
    }
}
