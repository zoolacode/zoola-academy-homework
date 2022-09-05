package com.zoolatech.lecture4.tasks._2;

/**
 * Create a class that represents a binary search tree
 * (https://en.wikipedia.org/wiki/Binary_search_tree). The tree should have
 * a reference to the root node. Each node stores an integer value and has
 * references to the left and right children nodes. The tree should also
 * have a method that accepts a value and adds it to the tree.
 */

public class Task2 {

    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.add(66);
        tree.add(14);
        tree.add(8);
        tree.add(13);
        tree.add(55);
        tree.add(7);
        tree.add(99);

        tree.inorder();
    }
}
