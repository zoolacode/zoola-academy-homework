package com.zoolatech.lecture6.tasks._3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cache implements UserCache{

    private final List<User> list;

    public Cache() {
        this.list = new ArrayList<>();
    }

    public Cache(List<User> list) {
        this.list = list;
    }

    public void add(User user) {
        list.add(user);
    }
    @Override
    public Optional<User> findUser(String id) {
        return list.stream().filter(u -> u.id().equals(id)).findFirst();
    }
}
