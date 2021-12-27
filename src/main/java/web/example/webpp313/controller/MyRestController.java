package web.example.webpp313.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.example.webpp313.model.User;
import web.example.webpp313.services.UserService;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {
    private final UserService userService;

    public MyRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> showAllUsers() {
        List<User> users = userService.resUsers();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("user/{id}")
    public ResponseEntity<User> getUser(@PathVariable ("id") Long id) {
        if (id==null) {
            return ResponseEntity.notFound().build();
        }
        User user = userService.showUser(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/new")
    public ResponseEntity<User> create(@RequestBody User user) {
       userService.createUser(user);
       return ResponseEntity.ok().body(user);
    }
//    @PostMapping("/new")
//    public ResponseEntity<User> create(@RequestBody User user, BindingResult bindingResult,
//                                       @RequestParam(required = false, name = "newRoles") String[] newRoles) {
//        if (bindingResult.hasErrors()) {
//        ResponseEntity.status(HttpStatus.RESET_CONTENT).build();
//    }
//    userService.createUser(user, newRoles);
//    return ResponseEntity.status(HttpStatus.CREATED).body(user);
//    }





    @PutMapping("/edit/{id}")
    public ResponseEntity<User> updateUser(Long id, @RequestBody User user) {
        userService.update(id, user);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping("/{id}/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }

}
