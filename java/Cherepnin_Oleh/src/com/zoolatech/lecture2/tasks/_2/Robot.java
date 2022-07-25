package com.zoolatech.lecture2.tasks._2;

public class Robot {
    private Direction direction;
    private final int width;
    private final int height;
    private int x;
    private int y;

    public Robot(int width, int height) {
        this(width, height, 0, 0);
    }

    public Robot(int width, int height, Direction direction) {
        this(width, height, 0, 0, direction);
    }

    public Robot(int width, int height, int x, int y) {
        this(width, height, x, y, Direction.SOUTH);
    }

    public Robot(int width, int height, int x, int y, Direction direction) {
        this.direction = direction;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    public void takeOneStep() {
        moveForward(1);
    }

    public void moveForward(int steps) {
        System.out.println(steps > 1 ? "The robot is taking " + steps + "steps to the " + direction
                : "The robot is taking one step to the " + direction);
        switch (direction) {
            case WEST -> this.x += move((steps * -1), this.x, 0);
            case NORTH -> this.y = move((steps * -1), this.y, 0);
            case EAST -> this.x = move(steps, this.x, this.width);
            case SOUTH -> this.y = move(steps, this.y, this.height);
        }
    }

    private int move(int steps, int position, int edge) {
        position += steps;
        if ((steps > 0 && position > edge)
                || (steps < 0 && position < edge)) {
            showAttention();
            return edge;
        }
        return position;
    }

    private void showAttention() {
        System.out.println("The robot has already come to border of room at " +
                direction + "\nRobot should change direction");
    }


    public void turnLeft() {
        direction = Direction.valueOf(direction.getLeft());
        showDirection();
    }

    public void turnRight() {
        direction = Direction.valueOf(direction.getRight());
        showDirection();
    }

    public void showPosition() {
        showDirection();
        System.out.println("Current location mark as '*'");

        for (int i = 0; i <= height; i++) {
            for (int j = 0; j <= width; j++) {
                if (i == y && j == x)
                    System.out.print("[ * ]");
                else System.out.print("[" + i + "," + j + "]");
            }
            System.out.println();
        }
    }

    private void showDirection() {
        System.out.println("Compass\n   N\nW  +  E\n   S");
        System.out.println("The robot looks " + direction);
    }
}
