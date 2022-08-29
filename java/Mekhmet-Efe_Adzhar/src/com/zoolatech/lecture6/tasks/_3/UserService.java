package com.zoolatech.lecture6.tasks._3;

class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String findUserEmail(String id) throws UserMissingException {
        if (!userRepository.findUserEmail(id).isEmpty()) {
            return userRepository.findUserEmail(id);
        }
        return "No such user in cash and table";
    }
}