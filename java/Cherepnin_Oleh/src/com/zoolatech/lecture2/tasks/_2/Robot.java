package com.zoolatech.lecture2.tasks._2;

public class Robot {
    private Direction direction;
    private Integer width;
    private Integer height;
    private int x;
    private int y;

    public Robot(int width, int height) {
        this(width, height, 0, 0);
    }

    public Robot(Integer width, Integer height, Direction direction) {
        this(width, height, 0, 0, direction);
    }

    public Robot(Integer width, Integer height, int x, int y) {
        this(width, height, x, y, Direction.SOUTH);
    }

    public Robot(Integer width, Integer height, int x, int y, Direction direction) {
        this.direction = direction;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    public void moveForward(int steps) {
        System.out.println("The robot is taking " + steps + "steps to the " + direction);
        switch (direction) {
            case WEST -> this.x = move((steps * -1), this.x, 0);
            case NORTH -> this.y = move((steps * -1), this.y, 0);
            case EAST -> this.x = move(steps, this.x, this.width);
            case SOUTH -> this.y = move(steps, this.y, this.height);
        }
    }

    private int move(int steps, int position, int edge) {
        position += steps;
        if (steps > 0)
            position = position > edge ? showAttention(edge) : position;
        else
            position = position < edge ? showAttention(edge) : position;
        return position;
    }

    private int showAttention(int edge) {
        System.out.println("Too many steps, the robot has already come to border of room at " +
                direction + "\nRobot should change direction");
        return edge;
    }


    public void turnLeft() {
        direction = Direction.valueOf(direction.getLeft());
        showDirection();
    }

    public void turnRight() {
        direction = Direction.valueOf(direction.getRight());
        showDirection();
    }

    private void showDirection(){
        System.out.println("Compass\n   N\nW  +  E\n   S");
        System.out.println("The robot looks " + direction);
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
}
