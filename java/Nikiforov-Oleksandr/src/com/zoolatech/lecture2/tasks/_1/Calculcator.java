package com.zoolatech.lecture2.tasks._1;

public class Calculcator {
    private float value;

    public Calculcator(float value){
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float multiplication(float variable){
        this.value *= variable;
        return this.value;
    }

    public float adding(float variable){
        this.value += variable;
        return this.value;
    }

    public float substracting(float variable){
        this.value -= variable;
        return this.value;
    }

    public float division(float variable){
        if(variable==0){
            System.out.println("DIvision by 0 is forbidden!");
            return 0;
        }else{
            this.value /= variable;
            return this.value;
        }
    }
}
