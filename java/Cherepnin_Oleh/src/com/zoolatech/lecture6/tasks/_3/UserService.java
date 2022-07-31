package com.zoolatech.lecture6.tasks._3;

import com.zoolatech.lecture6.tasks._3.storage.impl.UserCacheImpl;
import com.zoolatech.lecture6.tasks._3.storage.impl.UserTableImpl;

public class UserService {
    private UserRepository repository;

    {
        repository = new UserRepository(new UserCacheImpl(), new UserTableImpl());
    }

    public String findUserEmail(String id) {
        try {
            return repository.findUserEmail(id);
        } catch (UserMissingException exception) {
            return exception.getMessage();
        }
    }

}
