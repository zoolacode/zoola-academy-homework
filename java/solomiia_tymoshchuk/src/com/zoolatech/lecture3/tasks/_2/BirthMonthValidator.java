package com.zoolatech.lecture3.tasks._2;

import static java.lang.Integer.parseInt;

public class BirthMonthValidator extends AccountValidator
{
    public BirthMonthValidator(Long birthMonth){
        this.birthMonth = birthMonth;
    }

    @Override
    public boolean isValid(){
        boolean value;
        int birthMonthConverted = parseInt(String.valueOf(birthMonth));
        if(birthMonthConverted > 12) {
            value = false;
        } else if(birthMonthConverted < 1) {
            value = false;
        }
        else {value = true;}
        return value;
    }
}
