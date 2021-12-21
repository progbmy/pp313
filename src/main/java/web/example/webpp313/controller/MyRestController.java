package web.example.webpp313.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public List<String> showAllUsers() {
        List<String> user = new ArrayList<String>();
        user.add("usermane");
        user.add("user1");
        return user;
//        return userService.resUsers();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable ("id") int id) {
        return userService.showUser(id);
    }



}
