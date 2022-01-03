package web.example.webpp313.dao;

import web.example.webpp313.model.User;
import java.util.List;

public interface UserDAO {
    void create(User user);

    List<User> read();

    User readById(long id);

    User readByFirstName(String name);

    void update(User user);

    void delete(long id);
}
