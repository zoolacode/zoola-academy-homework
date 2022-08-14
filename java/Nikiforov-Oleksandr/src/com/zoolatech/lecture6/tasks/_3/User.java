package com.zoolatech.lecture6.tasks._3;

record User(String id, String email) {
    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }
}
