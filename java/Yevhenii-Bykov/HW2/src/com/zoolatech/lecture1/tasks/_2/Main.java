package com.zoolatech.lecture1.tasks._2;

public class Main {
    public static void main(String[] args) {
        RoboCleaner robot = new RoboCleaner(10, 10);
        System.out.println(robot.getLocation());
        robot.moveForward(15);
        System.out.println(robot.getLocation());
        robot.moveForward(10);
        robot.changeDirection(RoboCleaner.Direction.EAST);
        System.out.println(robot.getLocation());
        robot.moveForward(15);
        System.out.println(robot.getLocation());
        robot.changeDirection(RoboCleaner.Direction.NORTH);
        robot.moveForward(15);
        System.out.println(robot.getDirection());
        System.out.println(robot.getLocation());
        robot.changeDirection(RoboCleaner.Direction.WEST);
        robot.moveForward(5);
        System.out.println(robot.getLocation());
        robot.changeDirection(RoboCleaner.Direction.SOUTH);
        robot.moveForward(5);
        System.out.println(robot.getLocation());
    }
}
