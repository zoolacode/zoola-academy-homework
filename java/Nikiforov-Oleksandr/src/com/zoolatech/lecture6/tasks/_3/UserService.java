package com.zoolatech.lecture6.tasks._3;

public class UserService {
    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public String findUserEmail(String id){
        try{
            return repository.findUserEmail(id);
        }catch (UserMissingException e) {
            return null;
        }
    }
}
