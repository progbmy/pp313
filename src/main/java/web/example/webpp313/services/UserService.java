package web.example.webpp313.services;


import web.example.webpp313.model.Role;
import web.example.webpp313.model.User;

import java.util.List;

public interface UserService {
    List<User> resUsers();
    List<User> index();
    User showUser(int id);
    void createUser(User user);
    void update(int id, User updatedUser);
    void delete(int id);
    User findByUsername(String username);
    Role getRoleByName(String name);
}
