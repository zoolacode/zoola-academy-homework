package com.zoolatech.lecture6.tasks._3.storage;

import com.zoolatech.lecture6.tasks._3.User;

import java.util.Optional;

public interface UserCache {
    Optional<User> findUser(String id);
}
