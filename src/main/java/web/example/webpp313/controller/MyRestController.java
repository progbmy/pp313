package web.example.webpp313.controller;


import org.springframework.web.bind.annotation.*;
import web.example.webpp313.model.User;
import web.example.webpp313.services.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {
    private final UserService userService;

    public MyRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> showAllUsers() {
        return userService.resUsers();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable ("id") int id) {
        return userService.showUser(id);
    }

    @PostMapping("/new")
    public User create(@RequestBody User user) {
        userService.createUser(user);
        return user;
    }
    @PutMapping("/edit/{id}")
    public User updateUser(int id, @RequestBody User user) {
        userService.update(id, user);
        return user;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.delete(id);
    }
}
