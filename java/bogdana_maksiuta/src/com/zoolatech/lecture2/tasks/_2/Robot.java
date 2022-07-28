package com.zoolatech.lecture2.tasks._2;

/**
 * Please carefully read the task description: you need to have a class that provides following methods:
 *
 * move()
 * move(int tiles)
 * turnLeft()
 * turnRight()
 * currentLocation()
 * currentDirection()
 * constructors to properly create an object of this class
 */
public class Robot {
    private int h = 0;
    private int w = 0;
    private String direction = "south";
    private int widthRoom;
    private int heightRoom;
    public int getH() {
        return h;
    }
    public void setH(int h) {
        this.h = h;
    }
    public int getW() {
        return w;
    }
    public void setW(int w) {
        this.w = w;
    }
    public String getDirection() {
        return direction;
    }
    public void setDirection(String direction) {
        this.direction = direction;
    }
    public int getWidthRoom() {
        return widthRoom;
    }
    public void setWidthRoom(int widthRoom) {
        this.widthRoom = widthRoom;
    }
    public int getHeightRoom() {
        return heightRoom;
    }
    public void setHeightRoom(int heightRoom) {
        this.heightRoom = heightRoom;
    }

    public void move() {
        switch (getDirection()) {
            case "east" -> {
                w++;
                eastDirection();
            }
            case "west" -> {
                w--;
                westDirection();
            }
            case "north" -> {
                h--;
                northDirection();
            }
            case "south" -> {
                h++;
                southDirection();
            }
        }
    }

    public void move(int tiles) {
        switch (getDirection()) {
            case "east" -> {
                if ((getW() + tiles) < getWidthRoom()) {
                    w += tiles;
                    eastDirection();
                } else {
                    int allowed = getWidthRoom() - getW() - 1;
                    System.out.println("There is " + allowed + "allowed");
                }
            }
            case "west" -> {
                if ((getW() - tiles) >= 0) {
                    w -= tiles;
                    westDirection();
                } else {
                    System.out.println("There is " + (getW()) + "allowed");
                }

            }
            case "north" -> {
                if ((getH() - tiles) >= 0) {
                    h -= tiles;
                    northDirection();
                } else {
                    System.out.println("There is " + getH() + "allowed");
                }
            }
            case "south" -> {
                if ((getH() + tiles) < getHeightRoom()) {
                    h += tiles;
                    southDirection();
                } else {
                    int allowed = getHeightRoom() - getH() - 1;
                    System.out.println("There is " + allowed + "allowed");
                }
            }
        }
    }

    public void turnRight() {
        switch (getDirection()) {
            case "west" -> northDirection();
            case "north" -> eastDirection();
            case "east" -> southDirection();
            case "south" -> westDirection();
        }
    }

    public void turnLeft() {
        switch (getDirection()) {
            case "west" -> southDirection();
            case "south" -> eastDirection();
            case "east" -> northDirection();
            case "north" -> westDirection();
        }
    }

    public void currentLocation() {
        System.out.println("Your current position is: " + "[" + getW() + " : " + getH() + "] [weight : height]");
    }

    public void currentDirection() {
        System.out.println("Direction: " + getDirection());
    }

    public void southDirection() {
        if (h < (heightRoom - 1)) {
            System.out.println("My direction: SOUTH");
            setDirection("south");
        } else if (h == (heightRoom - 1) && w < heightRoom / 2 && w >= 0) {
            System.out.println("Hm. It's border. I need to go east");
            eastDirection();
        } else if (h == (heightRoom - 1) && w >= heightRoom / 2 && w <= heightRoom - 1) {
            System.out.println("Ops. It's border. I need to go west");
            westDirection();
        }
    }

    public void northDirection() {
        if (h > 0) {
            System.out.println("My direction: NORTH");
            setDirection("north");
        } else if (h == 0 && w < widthRoom / 2 && w >= 0) {
            System.out.println("Hm. It's border. I need to go east");
            eastDirection();
        } else if (h == 0 && w >= widthRoom / 2 && w <= widthRoom - 1) {
            System.out.println("Ops. It's border. I need to go west");
            westDirection();
        }
    }

    public void eastDirection() {
        if (w < widthRoom - 1) {
            System.out.println("My direction: EAST");
            setDirection("east");
        } else if (w == (widthRoom - 1) && h < heightRoom / 2 && h >= 0) {
            System.out.println("Hm. It's border. I need to go south");
            southDirection();
        } else if (w == (widthRoom - 1) && h >= heightRoom / 2 && h <= (heightRoom - 1)) {
            System.out.println("Ops. It's border. I need to go north");
            northDirection();
        }
    }

    public void westDirection() {
        if (w > 0) {
            System.out.println("My direction: WEST");
            setDirection("west");
        } else if (w == 0 && h < heightRoom / 2 && h >= 0) {
            System.out.println("Hm. It's border. I need to go south");
            southDirection();
        } else if (w == 0 && h >= heightRoom / 2 && h <= heightRoom - 1) {
            System.out.println("Ops. It's border. I need to go north");
            northDirection();
        }
    }
}
