package com.zoolatech.lecture3.tasks._2;

public class CountryValidator implements ValidatorInterface {
    private String country;

    public CountryValidator(String country) {
        this.country = country;
    }

    @Override
    public boolean isValid() {
        if (country.isEmpty()) {
            System.out.println("Field country is empty. Validation error");
            return false;
        } else {
            System.out.println("Field country is not empty");
            return true;
        }
    }
}
