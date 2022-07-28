package com.zoolatech.lecture1.tasks._2;

/**
 * Define a class that represents a robot, which moves in a room of a width W and a height of H.
 * The class should provide methods to move a robot forward
 * by either 1 or N tiles and turn it either left or right by 90 degrees from the current direction.
 * The class should also provide methods to get the robot's current location and direction.
 * The north-west corner of a room is represented by coordinates (0,0);
 * north-east - (W-1, 0); south-east - (W-1, H-1); south-west - (0, H-1).
 * By default, a robot should be placed in the north-west corner facing south direction.
 * However, it should be also possible to give any coordinates and direction as the initial robot location.
 * Robot must not be able to get outside of a room - in such case the robot should move as much as possible to the room border,
 * print a warning message and stop. All next moves in the same direction should be prevented.
 */

public class RoboCleaner {

    public enum Direction{
        SOUTH, NORTH, EAST, WEST
    }
    private final int width;
    private final int high;
    private int currentWidth;
    private int currentHigh;

    public RoboCleaner(int w, int h){
        width = w;
        high = h;
    }

    private Direction direction = Direction.SOUTH;

    public String getLocation(){
        if(currentHigh==0 && currentWidth==0){
            return "(0,0)";
        }
        if(currentHigh==0){
            return ("(W-" + currentWidth + ",0)");
        }
        if(currentWidth==0){
            return ("(0,H-" + currentHigh + ")");
        }
        return ("(W-" + currentWidth +"," + "H-" + currentHigh + ")");
    }

    public String getDirection() {
        return direction.toString();
    }

    public void moveForward(int step){
        String stuckError = "Cleaner stuck. Please, change direction.";
        String outOfMovesWarning = "Can't move forward anymore - bonked into the wall";
        switch (direction){
            case SOUTH -> {
                if (currentHigh == high){
                    System.out.println(stuckError);
                }
                else if (currentHigh + step >= high) {
                    currentHigh = high;
                    System.out.println(outOfMovesWarning);
                }
                else {
                    currentHigh += step;
                }
            }
            case EAST -> {
                if (currentWidth == width){
                    System.out.println(stuckError);
                }
                else if (currentWidth + step >= width) {
                    currentWidth = width;
                    System.out.println(outOfMovesWarning);
                }
                else {
                    currentWidth += step;
                }
            }
            case NORTH -> {
                if (currentHigh == 0){
                    System.out.println(stuckError);
                }
                else if (currentHigh - step <= 0) {
                    currentHigh = 0;
                    System.out.println(outOfMovesWarning);
                }
                else {
                    currentHigh -= step;
                }
            }
            case WEST -> {
                if (currentWidth == 0){
                    System.out.println(stuckError);
                }
                else if (currentWidth - step <= 0) {
                    currentWidth = 0;
                    System.out.println(outOfMovesWarning);
                }
                else {
                    currentWidth -= step;
                }
            }
        }
    }

    public void changeDirection(Direction dir){
        direction = dir;
    }
}
