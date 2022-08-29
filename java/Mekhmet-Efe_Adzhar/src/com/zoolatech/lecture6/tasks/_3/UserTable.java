package com.zoolatech.lecture6.tasks._3;

import java.util.Optional;

interface UserTable {
    Optional<User> findUser(String id);
}