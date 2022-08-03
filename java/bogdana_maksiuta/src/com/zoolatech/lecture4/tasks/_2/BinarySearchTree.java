package com.zoolatech.lecture4.tasks._2;

public class BinarySearchTree {
    private Node rootNode;

    static class Node {
        private Node leftChildNode;
        private Node rightChildNode;
        private int value;

        public Node getLeftChildNode() {
            return leftChildNode;
        }

        public void setLeftChildNode(Node leftChildNode) {
            this.leftChildNode = leftChildNode;
        }

        public Node getRightChildNode() {
            return rightChildNode;
        }

        public void setRightChildNode(Node rightChildNode) {
            this.rightChildNode = rightChildNode;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }


    public void addNode(int value) {
        Node node = new Node();
        node.setValue(value);
        if (rootNode == null) {
            rootNode = node;
        } else {
            Node currentNode = rootNode;
            Node parentNode;
            parentNode = currentNode;
            if (value < currentNode.getValue()) {
                currentNode = currentNode.getLeftChildNode();
                if (currentNode == null) {
                    parentNode.setLeftChildNode(node);
                }
            } else {
                currentNode = currentNode.getRightChildNode();
                if (currentNode == null) {
                    parentNode.setRightChildNode(node);
                }
            }
        }
    }
}
