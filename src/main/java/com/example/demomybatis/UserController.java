package com.example.demomybatis;


import org.apache.ibatis.annotations.ResultMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public User getById(@PathVariable Integer userId) {
        return userService.getById(userId);
    }

    @DeleteMapping("/{userId}")
    public User deleteById(@PathVariable Integer userId) {
        return userService.deleteById(userId);
    }

    @PutMapping("/{userId}")
    public User deleteById(@PathVariable Integer userId, @RequestBody User user) {
        return userService.updateById(userId,user);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody User user) {
        return ResponseEntity.ok().body(userService.create(user));
    }
}
