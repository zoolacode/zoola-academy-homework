package com.zoolatech.lecture6.tasks._3;

import com.zoolatech.lecture6.tasks._3.storage.impl.UserCacheImpl;
import com.zoolatech.lecture6.tasks._3.storage.impl.UserTableImpl;

public class UserService {
    private UserRepository repository = new UserRepository(new UserCacheImpl(), new UserTableImpl());

    public String findUserEmail(String id) {
        try {
            return repository.findUserEmail(id);
        } catch (UserMissingException exception) {
            System.out.println(exception.getMessage());
        }
        return "Something went wrong...";
    }
}
