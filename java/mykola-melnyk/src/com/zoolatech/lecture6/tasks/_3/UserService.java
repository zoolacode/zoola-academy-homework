package com.zoolatech.lecture6.tasks._3;

public class UserService {
    UserRepository userRepoInst;

    public String findUserEmail(String id) {
        try {
            return userRepoInst.findUserEmail(id);
        } catch (UserMissingException e) {
            System.out.printf("User with ID %s not found!", e.getMissingID());
            return null;
        }
    }

}

