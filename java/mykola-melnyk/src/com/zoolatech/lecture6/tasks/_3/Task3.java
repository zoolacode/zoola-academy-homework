package com.zoolatech.lecture6.tasks._3;

/**
 * Create a class UserRepository with a method String findUserEmail(String id). The class constructor needs to
 * accept an instance of an interface UserCache (contains a single method Optional<User> findUser(String id))
 * and an instance of an interface UserTable (contains a single method with the same signature as the cache).
 * The method findUserEmail needs to use a cache instance to retrieve a user from it, if it’s missing in cache
 * - retrieve a user from the table, if it’s missing there as well - throw a custom checked exception
 * UserMissingException with details regarding the exception and the id of a missing record. If a user was
 * found either in cache or in a table - the method needs to return the user's email. User has the following
 * properties: string id, string email. Create another class UserService that has an instance of
 * UserRepository and a method String findUserEmail(String id). UserService needs to call the method of
 * UserRepository and properly handle the thrown exception (it’s enough to print information to the output).
 */

public class Task3 {
    public static void main(String[] args) {
        User Mykola = new User("1", "123");
        User Violet = new User("2", "234");
        User Max = new User("3", "345");
        User Valeriia = new User("4", "456");
        User Oleg = new User("5", "567");
        User Viktoriia = new User("6", "678");
        DefaultUserTable myDefaultUserTable = new DefaultUserTable(Mykola, Violet, Max);
        DefaultUserCache myDefaultUserCache = new DefaultUserCache(Valeriia, Oleg, Viktoriia);
        UserRepository myUserRepository = new UserRepository(myDefaultUserCache, myDefaultUserTable);
        UserService myUserService = new UserService(myUserRepository);
        System.out.println(myUserService.findUserEmail("1"));
        System.out.println(myUserService.findUserEmail("5"));
        System.out.println(myUserService.findUserEmail("10"));

    }
}
