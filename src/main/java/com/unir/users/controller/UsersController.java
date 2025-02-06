package com.unir.users.controller;

import com.unir.users.model.pojo.User;
import com.unir.users.model.request.CreateUserRequest;
import com.unir.users.service.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j


public class UsersController {
    private final UsersService usersService;

    @GetMapping("/users")

    public ResponseEntity<List<User>> getUsers(@RequestHeader Map<String, String> headers) {
        log.info("headers: {}", headers);
        List<User> users = usersService.getUsers();
        if (users == null) {
            return ResponseEntity.ok(Collections.emptyList());
        } else {
            return ResponseEntity.ok(users);
        }
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Long userId) {
        log.info("Solicitud de recepción de un usuario{}", userId);
        User user = usersService.getUser(String.valueOf(userId));
        if (user == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(user);
        }
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        Boolean removed = usersService.deleteUser(userId);
        if (Boolean.TRUE.equals(removed)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody CreateUserRequest request) {
        User newUser = usersService.addUser(request);
        if (newUser == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
        }
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody CreateUserRequest request) {
        User updatedUser = usersService.updateUser(userId, request);
        if (updatedUser == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(updatedUser);
        }
    }


}
