package com.zoolatech.lecture6.tasks._3;

class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String findUserEmail(String id) throws UserMissingException {
        try {
            return userRepository.findUserEmail(id);
        } catch (UserMissingException userMissingException) {
            throw new UserMissingException(id + ": No such user in cash and table");
        }
    }
}