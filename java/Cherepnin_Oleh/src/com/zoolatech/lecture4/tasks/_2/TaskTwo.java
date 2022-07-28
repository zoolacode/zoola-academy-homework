package com.zoolatech.lecture4.tasks._2;

/**
 * Create a class that represents a binary search tree (https://en.wikipedia.org/wiki/Binary_search_tree).
 * The tree should have a reference to the root node. Each node stores an integer value and has references
 * to the left and right children nodes. The tree should also have a method that accepts a value and adds it to the tree.
 */
public class TaskTwo {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.add(1);
        tree.add(2);
        tree.add(8);
        tree.add(5);
        tree.add(3);
        tree.add(10);
        tree.add(-2);
        tree.print();
        System.out.println(tree.add(3));
    }
}

