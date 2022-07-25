package com.zoolatech.lecture2.tasks._2;


/**
 * Define a class that represents a robot, which moves in a room of a width W and a height of H.
 * The class should provide methods to move a robot forward by either 1 or N tiles and turn it
 * either left or right by 90 degrees from the current direction. The class should also provide
 * methods to get the robot's current location and direction.
 * The north-west corner of a room is represented by coordinates (0,0);
 * north-east - (W-1, 0);
 * south-east - (W-1, H-1);
 * south-west - (0, H-1).
 * By default, a robot should be placed in
 * the north-west corner facing south direction. However, it should be also possible to give
 * any coordinates and direction as the initial robot location. Robot must not be able to get
 * outside of a room - in such case the robot should move as much as possible to the room border,
 * print a warning message and stop. All next moves in the same direction should be prevented.
 */

public class TaskTwo {

    public static void main(String[] args) {
        RobotController robotController = new RobotController();
        robotController.createRobot();
        robotController.controlRobot();
    }
}

