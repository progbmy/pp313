package web.example.webpp313.dao;

import web.example.webpp313.model.User;
import java.util.List;

public interface UserDAO {
    List<User> resUsers();
    List<User> index();
    User showUser(Long id);
    void createUser(User user);
    void update(Long id, User updatedUser);
    void delete(Long id);
    User findByUsername(String username);

}
