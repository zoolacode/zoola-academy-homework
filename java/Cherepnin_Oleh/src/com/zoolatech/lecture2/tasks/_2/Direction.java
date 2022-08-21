package com.zoolatech.lecture2.tasks._2;

public enum Direction {
    NORTH("EAST", "WEST"),
    EAST("SOUTH", "NORTH"),
    SOUTH("WEST", "EAST"),
    WEST("NORTH", "SOUTH");

    private String right;
    private String left;

    Direction(String right, String left) {
        this.right = right;
        this.left = left;
    }

    public String getRight() {
        return right;
    }

    public String getLeft() {
        return left;
    }
}
