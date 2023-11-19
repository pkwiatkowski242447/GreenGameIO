package io.greengame.greengameio.controller;


import io.greengame.greengameio.entity.User;
import io.greengame.greengameio.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @DeleteMapping("/username/{username}")
    boolean deleteUser(@PathVariable String username) {
        return userService.deleteUser(username);
    }

    @GetMapping
    List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/email/{email}")
    User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @GetMapping("/username/{username}")
    UserDetails getUserByUsername(@PathVariable String username) {
        return userService.loadUserByUsername(username);
    }

    @GetMapping("/id/{id}")
    User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/username/{username}")
    User updateUser(@PathVariable String username, @RequestBody User user) {
        return userService.updateUser(username, user);
    }
}