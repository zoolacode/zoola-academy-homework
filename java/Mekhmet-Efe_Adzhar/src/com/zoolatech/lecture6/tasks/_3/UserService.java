package com.zoolatech.lecture6.tasks._3;

class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String findUserEmail(String id) {
        try {
            return userRepository.findUserEmail(id);
        } catch (UserMissingException userMissingException) {
            System.out.println("Exception " + userMissingException);
        }
        return null;
    }
}