package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static Integer usersCount = 0;

    static {
        users.add(new User(++usersCount, "conor", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "ben", LocalDate.now().minusYears(20)));
        users.add(new User(++usersCount, "ronoc", LocalDate.now().minusYears(25)));
    }
//    Find All Users
    public List<User> findAll() {
        return users;
    }
//    Save a User
    public User save(User user){
        user.setId(++usersCount);
        users.add(user);
        return user;
    }
//    Find one Specific User

    public User findOne(int id){
       return users.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
    }
    public void deleteById(int id){
        users.removeIf(u -> u.getId().equals(id));

    }
}
