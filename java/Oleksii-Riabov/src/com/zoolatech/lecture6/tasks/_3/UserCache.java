package com.zoolatech.lecture6.tasks._3;

import java.util.Optional;

public interface UserCache {

    Optional<User> findUser(String id);
}
