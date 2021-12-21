package web.example.webpp313.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.example.webpp313.model.Role;
import web.example.webpp313.model.User;
import web.example.webpp313.services.UserService;


import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/admin/users")
public class AdminController {


    private final UserService userService;
    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUser(Model model) {
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("user", userService.findByUsername(user));
        model.addAttribute("users", userService.resUsers());
        return "/_users";
//        return "/users";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("users", userService.showUser(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "_new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user,
                         @RequestParam("role") String[] role) {
        Set<Role> roleSet = new HashSet<>();
        for (String roles : role) {
            roleSet.add(userService.getRoleByName(roles));
        }
        user.setRoles(roleSet);
        userService.createUser(user);

        return "redirect:/admin/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("users", userService.showUser(id));
        return ("edit");
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("users") User user, @PathVariable("id") int id, @RequestParam("role") String[] role) {
        Set<Role> roleSet = new HashSet<>();
        for (String roles : role) {
            roleSet.add(userService.getRoleByName(roles));
        }
        user.setRoles(roleSet);
        userService.update(id, user);
        return "redirect:/admin/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/admin/users";
    }

}
