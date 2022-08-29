package com.zoolatech.lecture6.tasks._3;

class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public String findUserEmail(String id) {
        try {
            if (!userRepository.findUserEmail(id).isEmpty()) {
                return userRepository.findUserEmail(id);
            }
        } catch (UserMissingException userRepository) {
            System.out.println("Exception " + userRepository);
        }
        return null;
    }
}