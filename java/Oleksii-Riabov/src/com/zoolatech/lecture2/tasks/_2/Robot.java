package com.zoolatech.lecture2.tasks._2;

public class Robot {
    private final Room room;
    Direction direction;
    private int width;
    private int height;

    public Robot() {
        this.room = new Room(1, 1);
        this.direction = Direction.SOUTH;
        this.width = 0;
        this.height = 0;
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

    public void warning() {
        System.out.println("The Robot reach the end of a room and can't move forward, please change Robot's direction.");
    }

    public void checkLocation() {
        if (this.width < 0 & this.height < 0) {
            this.width = 0;
            this.height = 0;
            warning();
        } else if (this.width > room.width & this.height > room.height) {
            this.width = room.width();
            this.height = room.height();
            warning();
        } else if (this.height < 0) {
            this.height = 0;
            warning();
        } else if (this.height > room.height()) {
            this.height = room.height();
            warning();
        } else if (this.width < 0) {
            this.width = 0;
            warning();
        } else if (this.width > room.width()) {
            this.width = room.width();
            warning();
        }
    }

    public void move() {
        switch (direction) {
            case NORTH -> {
                this.height--;
                checkLocation();
            }
            case SOUTH -> {
                this.height++;
                checkLocation();
            }
            case EAST -> {
                this.width++;
                checkLocation();
            }
            case WEST -> {
                this.width--;
                checkLocation();
            }
        }
    }

    public void move(int titles) {
        switch (direction) {
            case NORTH -> {
                this.height -= titles;
                checkLocation();
            }
            case SOUTH -> {
                this.height += titles;
                checkLocation();
            }
            case EAST -> {
                this.width += titles;
                checkLocation();
            }
            case WEST -> {
                this.width -= titles;
                checkLocation();
            }
        }
    }

    public void turnLeft() {
        this.direction = direction.turnLeft();
    }

    public void turnRight() {
        this.direction = direction.turnRight();
    }

    public void getCoordinates() {
        System.out.println("Current Robot's coordinates are (W-" + width + ",H-" + height + ")");
    }

    public record Room(int width, int height) {
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
}
