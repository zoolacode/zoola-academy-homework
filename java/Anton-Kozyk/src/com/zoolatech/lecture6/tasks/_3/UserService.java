package com.zoolatech.lecture6.tasks._3;

public class UserService {
    private Cache cache = new Cache();
    private Table userTable = new Table();

    private UserRepository userRepository = new UserRepository(cache, userTable);

    public void addUser(User user) {
        userTable.addToUserList(user);
    }

    public void addToCache(User user) {
        cache.addToCache(user);
    }

    public String findUserEmail(String id) {
        try {
            return userRepository.findUserEmail(id);
        } catch (UserMissingException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return null;
    }
}
