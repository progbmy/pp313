package web.example.webpp313.services;


import web.example.webpp313.model.Role;
import web.example.webpp313.model.User;

import java.util.List;

public interface UserService {
    List<User> resUsers();
    List<User> index();
    User showUser(Long id);
    void createUser(User user);
    void update(Long id, User updatedUser);
    void delete(Long id);
    User findByUsername(String username);
    Role getRoleByName(String name);
}
