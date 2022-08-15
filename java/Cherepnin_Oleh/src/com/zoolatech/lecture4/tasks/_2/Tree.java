package com.zoolatech.lecture4.tasks._2;

public class Tree {
    private Node head;

    public boolean add(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return true;
        }

        Node current = this.head;
        do {
            if (value == current.getValue()) {
                return false;
            }
            if (value < current.getValue()) {
                if (current.getLeft() == null) {
                    current.setLeft(newNode);
                    return true;
                } else {
                    current = current.getLeft();
                }
            } else if (value > current.getValue()) {
                if (current.getRight() == null) {
                    current.setRight(newNode);
                    return true;
                } else {
                    current = current.getRight();
                }
            }
        } while (true);
    }

    public void print() {
        showNodes(head);
    }

    private void showNodes(Node startNode) {
        if (startNode != null) {
            showNodes(startNode.getLeft());
            startNode.printNode();
            showNodes(startNode.getRight());
        }
    }
}
