package com.zoolatech.lecture2.tasks._2;

public class Robot {
    private int w, h, n;
    // direction = 0 - move right
    // direction = 1 - move up
    // direction = 2 - move left
    // direction = 3 - move down
    private int direction;

    public Robot(int n) {
        this.direction =0;
        this.w = 0;
        this.h = 0;
        this.n = n-1;
    }

    public void move(int step){
        if (this.direction==0){
            this.w+=step;
            if(this.w>this.n){
                System.out.println("The robot tried to get out of the room.");
                this.w = this.n;
            }else if (this.w<1) {
                System.out.println("The robot tried to get out of the room.");
                this.w = 1;
            }
        } else if (this.direction==1) {
            this.h+=step;
            if(this.h>this.n){
                System.out.println("The robot tried to get out of the room.");
                this.h = this.n;
            }else if (this.h<1) {
                System.out.println("The robot tried to get out of the room.");
                this.h = 1;
            }
        }else if (this.direction==2) {
            this.w-=step;
            if(this.w>this.n){
                System.out.println("The robot tried to get out of the room.");
                this.w = this.n;
            }else if (this.w<1) {
                System.out.println("The robot tried to get out of the room.");
                this.w = 1;
            }
        }else if (this.direction==3) {
            this.h-=step;
            if(this.h>this.n){
                System.out.println("The robot tried to get out of the room.");
                this.h = this.n;
            } else if (this.h<1) {
                System.out.println("The robot tried to get out of the room.");
                this.h = 1;
            }
        }

    }
    public void changeDirection(char direct){
        if (direct=='L'){
            this.direction+=1;
        } else if (direct=='R') {
            this.direction-=1;
        }else{
            System.out.println("Incorrect input!");
        }
        this.direction = this.direction % 4;
        if (this.direction<0){
            this.direction+=4;
        }
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getH() {
        return h;
    }

    public void getCoordinates(){
        System.out.println("Current coordinates are ("+getW()+";"+getH()+")");
    }

    public void getDirection(){
        switch (direction){
            case 0:
                System.out.println("The current direction of the robot to the right");
                break;
            case 1:
                System.out.println("The current direction of the robot upwards");
                break;
            case 2:
                System.out.println("The current direction of the robot to the left");
            case 3:
                System.out.println("The current direction of the robot down");
            default:
                System.out.println("System error!");
        }

    }
}
