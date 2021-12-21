package web.example.webpp313.dao;

import web.example.webpp313.model.User;
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
