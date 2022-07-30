package com.zoolatech.lecture4.tasks._2;

public class BinaryTree {
    private Node root;

    static class Node {
        private int value;

        public Node(int value) {
            this.value = value;
        }

        Node leftBranch;
        Node rightBranch;

        public void setLeftBranch(Node leftBranch) {
            this.leftBranch = leftBranch;
        }

        public void setRightBranch(Node rightBranch) {
            this.rightBranch = rightBranch;
        }
    }

    void insert(int value) {
        Node node = new Node(value);

        if (root == null) {
            root = node;
            return;
        }

        Node actualNode = root;

        while (true) {
            if (value > actualNode.value) {

                if (actualNode.rightBranch == null) {
                    actualNode.setRightBranch(node);
                    return;
                } else {
                    actualNode = actualNode.rightBranch;
                }

            } else if (value < actualNode.value) {

                if (actualNode.leftBranch == null) {
                    actualNode.setLeftBranch(node);
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
