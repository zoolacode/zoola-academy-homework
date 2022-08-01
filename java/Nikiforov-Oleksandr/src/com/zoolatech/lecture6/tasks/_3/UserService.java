package com.zoolatech.lecture6.tasks._3;

public class UserService {
    public UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public String findUserEmail(String id) throws UserMissingException {
        return repository.findUserEmail(id);
    }
}
