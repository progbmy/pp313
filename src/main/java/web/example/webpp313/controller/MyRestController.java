package web.example.webpp313.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.example.webpp313.services.UserService;

@RestController
@RequestMapping("/api")
public class MyRestController {
    @Autowired
    private UserService userService;


}
