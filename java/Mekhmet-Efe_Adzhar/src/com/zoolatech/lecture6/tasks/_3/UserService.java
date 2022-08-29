package com.zoolatech.lecture6.tasks._3;

record UserService(UserRepository userRepository) {

    public String findUserEmail(String id) throws UserMissingException {
        if (!userRepository.findUserEmail(id).isEmpty()) {
            return userRepository.findUserEmail(id);
        }
        return "No such user in cash and table";
    }
}