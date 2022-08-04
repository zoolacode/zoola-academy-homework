package com.zoolatech.lecture6.tasks._3;

record User(String userId, String email) {

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }
}