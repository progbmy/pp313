package web.example.webpp311.dao;

import web.example.webpp311.model.User;
import java.util.List;

public interface UserDAO {
    List<User> resUsers();
    List<User> index();
    User showUser(int id);
    void createUser(User user);
    void update(int id, User updatedUser);
    void delete(int id);
    User findByUsername(String username);

}
