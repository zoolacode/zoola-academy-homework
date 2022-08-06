package com.zoolatech.lecture2.tasks._2;

public class Robot {

    private final Room room;
    private Direction direction;
    private int width;
    private int height;

    public Robot() {
        this(1, 1, "SOUTH", 0, 0);
    }

    public Robot(int roomWidth, int roomHeight, String direction, int robotsStartingWidth, int robotStartingHeight) {
        this.room = new Room(roomWidth, roomHeight);
        this.direction = Direction.valueOf(direction);
        this.width = robotsStartingWidth;
        this.height = robotStartingHeight;
    }

    public Room getRoom() {
        return room;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void move(int tiles) {
        switch (direction) {
            case NORTH -> {
                this.height -= tiles;
                checkLocation();
            }
            case SOUTH -> {
                this.height += tiles;
                checkLocation();
            }
            case EAST -> {
                this.width += tiles;
                checkLocation();
            }
            case WEST -> {
                this.width -= tiles;
                checkLocation();
            }
        }
    }

    public void checkLocation() {
        if (this.height < 0) {
            this.height = 0;
            printWarning();
        } else if (this.height > room.height()) {
            this.height = room.height();
            printWarning();
        } else if (this.width < 0) {
            this.width = 0;
            printWarning();
        } else if (this.width > room.width()) {
            this.width = room.width();
            printWarning();
        }
    }

    public void printWarning() {
        System.out.println("The Robot reach the end of a room and can't move forward, please change Robot's direction.");
    }

    public void getCoordinates() {
        System.out.println("Current Robot's coordinates are (W-" + width + ",H-" + height + ")");
    }

    @Override
    public String toString() {
        return  "You create Room of " + (room.width() + 1) + " tiles height and of " +
                "" + (room.height() + 1) + " tiles wide (W-H(0-" + room.width() + ",0-"
                + room.height() + "))," + "\nRobot's direction is: "
                + direction + ", \nRobot's coordinates are: " +
                "Width-Height(" + width + "," + height + ").\n";
    }

    public void turnLeft() {
        this.direction = direction.turnLeft();
    }

    public void turnRight() {
        this.direction = direction.turnRight();
    }

    public enum Direction {
        NORTH {
            @Override
            public Direction turnLeft() {
                return Direction.WEST;
            }

            @Override
            public Direction turnRight() {
                return Direction.EAST;
            }
        },
        SOUTH {
            @Override
            public Direction turnLeft() {
                return Direction.EAST;
            }

            @Override
            public Direction turnRight() {
                return Direction.WEST;
            }
        },
        WEST {
            @Override
            public Direction turnLeft() {
                return Direction.SOUTH;
            }

            @Override
            public Direction turnRight() {
                return Direction.NORTH;
            }
        },
        EAST {
            @Override
            public Direction turnLeft() {
                return Direction.NORTH;
            }

            @Override
            public Direction turnRight() {
                return Direction.SOUTH;
            }
        };

        public abstract Direction turnLeft();

        public abstract Direction turnRight();
    }

    public record Room(int width, int height) {}
}
