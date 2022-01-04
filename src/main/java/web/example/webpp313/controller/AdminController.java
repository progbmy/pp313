package web.example.webpp313.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.example.webpp313.model.Role;
import web.example.webpp313.model.User;
import web.example.webpp313.services.RoleService;
import web.example.webpp313.services.UserService;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String printUser(Model model) {
        model.addAttribute("users", userService.read());

        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("roles", roleService.getAllRoles());

        return "admin";
    }

    @PostMapping()
    public String create(@ModelAttribute(value = "user") User user,
                         @RequestParam(name = "roles", required = false) String... roles) {
        List<Role> listRoles = readRoles(roles);
        user.setRoles(listRoles);
        userService.create(user);
        return "redirect:/admin";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user
            , @RequestParam(name = "roles", required = false) String... roles) {
        List<Role> listRoles = readRoles(roles);
        user.setRoles(listRoles);
        userService.update(user);
        return "redirect:/admin";
    }

    @DeleteMapping(value = "/{id}")
    public String deleteUser(@PathVariable long id) {
        userService.delete(id);
        return "redirect:/admin";
    }

    private List<Role> readRoles(String... role) {
        List<Role> roles = new ArrayList<>();
        if (role != null) {
            for (String s : role) {
                roles.add(roleService.readByRole(s));
            }
        }
        return roles;
    }

}
