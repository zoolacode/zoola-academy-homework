package com.zoolatech.lecture6.tasks._3;

/**
 * Create a class UserRepository with a method String findUserEmail(String id).
 * The class constructor needs to accept an instance of an interface UserCache (contains a single method
 * Optional<User> findUser(String id)) and an instance of an interface UserTable (contains a single method
 * with the same signature as the cache). The method findUserEmail needs to use a cache instance to retrieve
 * a user from it, if it’s missing in cache - retrieve a user from the table, if it’s missing there as well -
 * throw a custom checked exception UserMissingException with details regarding the exception and the id of a
 * missing record. If a user was found either in cache or in a table - the method needs to return the user's email.
 * User has the following properties: string id, string email. Create another class UserService that has an instance
 * of UserRepository and a method String findUserEmail(String id). UserService needs to call the method of
 * UserRepository and properly handle the thrown exception (it’s enough to print information to the output).
 */

public class Task3 {
    public static void main(String[] args) throws UserMissingException {
        UserService service = new UserService(new UserRepository(new UsersCacheClass(), new UserTableClass()));
        System.out.println(service.findUserEmail("1"));
        System.out.println(service.findUserEmail("4"));
        System.out.println(service.findUserEmail("7"));
    }
}
