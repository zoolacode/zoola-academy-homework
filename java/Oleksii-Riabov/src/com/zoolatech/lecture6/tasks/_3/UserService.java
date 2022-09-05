package com.zoolatech.lecture6.tasks._3;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String findUserEmail(String id) {
        try {
            return userRepository.findUserEmail(id);
        } catch (UserMissingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
