package com.zoolatech.lecture2.tasks._2;

public class Robot {
    private int width;
    private int height;
    private final int maxWidth;
    private final int maxHeight;
    private final int amountOfDirections = 4;
    // direction = 0 - move right
    // direction = 1 - move up
    // direction = 2 - move left
    // direction = 3 - move down
    private int direction;

    public Robot(int maxWidth, int maxHeight) {
        this.direction = 0;
        this.width = 0;
        this.height = 0;
        this.maxWidth = maxWidth - 1;
        this.maxHeight = maxHeight - 1;
    }

    public void moveOnTile() {
        if (this.direction == 0) {
            this.width++;
            if (this.width > this.maxWidth) {
                System.out.println("The robot tried to get out of the room.");
                this.width = this.maxWidth;
            }
        } else if (this.direction == 1) {
            this.height++;
            if (this.height > this.maxHeight) {
                System.out.println("The robot tried to get out of the room.");
                this.height = this.maxHeight;
            }
        } else if (this.direction == 2) {
            this.width--;
            if (this.width < 0) {
                System.out.println("The robot tried to get out of the room.");
                this.width = 0;
            }
        } else if (this.direction == 3) {
            this.height--;
            if (this.height < 0) {
                System.out.println("The robot tried to get out of the room.");
                this.height = 0;
            }
        }

    }

    public void move(int step) {
        if (this.direction == 0) {
            this.width += step;
            if (this.width > this.maxWidth) {
                System.out.println("The robot tried to get out of the room.");
                this.width = this.maxWidth;
            }
        } else if (this.direction == 1) {
            this.height += step;
            if (this.height > this.maxHeight) {
                System.out.println("The robot tried to get out of the room.");
                this.height = this.maxHeight;
            }
        } else if (this.direction == 2) {
            this.width -= step;
            if (this.width < 0) {
                System.out.println("The robot tried to get out of the room.");
                this.width = 0;
            }
        } else if (this.direction == 3) {
            this.height -= step;
            if (this.height < 0) {
                System.out.println("The robot tried to get out of the room.");
                this.height = 0;
            }
        }

    }

    public void changeDirection(char direct) {
        if (direct == 'L') {
            this.direction++;
        } else if (direct == 'R') {
            this.direction--;
        } else {
            System.out.println("Incorrect input!");
        }
        this.direction = this.direction % amountOfDirections;
        if (this.direction < 0) {
            this.direction += amountOfDirections;
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if (width < 0) {
            this.width = 0;
        } else this.width = Math.min(width, maxWidth);
    }

    public void setHeight(int height) {
        if (height < 0) {
            this.height = 0;
        } else this.height = Math.min(height, maxHeight);
    }

    public int getHeight() {
        return height;
    }

    public void getCoordinates() {
        System.out.println("Current coordinates are (" + width + ";" + height + ")");
    }

    public void getDirection() {
        switch (direction) {
            case 0 -> System.out.println("The current direction of the robot to the right");
            case 1 -> System.out.println("The current direction of the robot upwards");
            case 2 -> System.out.println("The current direction of the robot to the left");
            case 3 -> System.out.println("The current direction of the robot down");
            default -> System.out.println("System error!");
        }

    }
}
