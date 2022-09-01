package com.zoolatech.lecture4.tasks._2;

public class BinaryTree {
    private Node root;

    private static class Node {
        private int value;

        public Node(int value) {
            this.value = value;
        }

        Node leftBranch;
        Node rightBranch;
    }

    public void insert(int value) {
        Node node = new Node(value);

        if (root == null) {
            root = node;
            return;
        }

        Node actualNode = root;

        while (true) {
            if (value > actualNode.value) {

                if (actualNode.rightBranch == null) {
                    actualNode.rightBranch = node;
                    return;
                } else {
                    actualNode = actualNode.rightBranch;
                }

            } else if (value < actualNode.value) {

                if (actualNode.leftBranch == null) {
                    actualNode.leftBranch = node;
                    return;
                } else {
                    actualNode = actualNode.leftBranch;
                }

            } else {
                return;
            }
        }
    }
}
