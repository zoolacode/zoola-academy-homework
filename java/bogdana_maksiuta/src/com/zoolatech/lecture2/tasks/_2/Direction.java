package com.zoolatech.lecture2.tasks._2;

public class Direction {
    public String southDirection() {
        if (Config.h < Config.HEIGHT_ROOM - 1) {
            System.out.println("My direction: SOUTH");
            return Config.direction = "south";
        } else if (Config.h == Config.HEIGHT_ROOM - 1 && Config.w < 5 && Config.w >= 0) {
            System.out.println("Hm. It's border. I need to go east");
            eastDirection();
        } else if (Config.h == Config.HEIGHT_ROOM - 1 && Config.w >= 5 && Config.w <= Config.WIDTH_ROOM - 1) {
            System.out.println("Ops. It's border. I need to go west");
            westDirection();
        }
        return Config.direction;
    }

    public String northDirection() {
        if (Config.h > 0) {
            System.out.println("My direction: NORTH");
            return Config.direction = "north";
        } else if (Config.h == 0 && Config.w < 5 && Config.w >= 0) {
            System.out.println("Hm. It's border. I need to go east");
            eastDirection();
        } else if (Config.h == 0 && Config.w >= 5 && Config.w <= Config.WIDTH_ROOM - 1) {
            System.out.println("Ops. It's border. I need to go west");
            westDirection();
        }
        return Config.direction;
    }

    public String eastDirection() {
        if (Config.w < Config.WIDTH_ROOM - 1) {
            System.out.println("My direction: EAST");
            return Config.direction = "east";
        } else if (Config.w == Config.WIDTH_ROOM - 1 && Config.h < 5 && Config.h >= 0) {
            System.out.println("Hm. It's border. I need to go south");
            southDirection();
        } else if (Config.w == Config.WIDTH_ROOM - 1 && Config.h >= 5 && Config.h <= Config.HEIGHT_ROOM - 1) {
            System.out.println("Ops. It's border. I need to go north");
            northDirection();
        }
        return Config.direction;
    }

    public String westDirection() {
        if (Config.w > 0) {
            System.out.println("My direction: WEST");
            return Config.direction = "west";
        } else if (Config.w == 0 && Config.h < 5 && Config.h >= 0) {
            System.out.println("Hm. It's border. I need to go south");
            southDirection();
        } else if (Config.w == 0 && Config.h >= 5 && Config.h <= Config.HEIGHT_ROOM - 1) {
            System.out.println("Ops. It's border. I need to go north");
            northDirection();
        }
        return Config.direction;
    }
}
