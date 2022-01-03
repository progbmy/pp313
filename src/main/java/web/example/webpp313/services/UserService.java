package web.example.webpp313.services;


import web.example.webpp313.model.User;

import java.util.List;

public interface UserService {
    void create(User user);

    List<User> read();
    User readById(long id);
    void update(User user);
    void delete(long id);
}
