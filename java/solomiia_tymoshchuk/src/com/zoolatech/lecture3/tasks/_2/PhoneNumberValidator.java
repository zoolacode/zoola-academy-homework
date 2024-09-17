package com.zoolatech.lecture3.tasks._2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator extends AccountValidator {

    public PhoneNumberValidator(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public boolean isValid() {
        Pattern pattern = Pattern.compile("^\\d{10}$");
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
