package web.example.webpp312.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.example.webpp312.dao.UserDAO;
import web.example.webpp312.services.UserService;


@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showUser(Model model) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
//        model.addAttribute("user", userDAO.findByUsername(name));
        model.addAttribute("user", userService.findByUsername(name));
        return "_user";
    }
}
