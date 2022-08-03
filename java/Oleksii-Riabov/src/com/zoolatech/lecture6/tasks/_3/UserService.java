package com.zoolatech.lecture6.tasks._3;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String findUserEmail(String id) {
        String s = "Email is not found.";
        try {
            return userRepository.findUserEmail(id);
        } catch (UserMissingException e) {
            e.printStackTrace();
        }
        return s;
    }
}
