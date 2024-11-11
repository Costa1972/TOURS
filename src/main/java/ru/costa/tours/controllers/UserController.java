package ru.costa.tours.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.costa.tours.models.User;
import ru.costa.tours.services.UserService;

import java.util.List;


@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/persons")
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping(value = "/person/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping(value = "/person/{phone}")
    public ResponseEntity<User> getByPhone(@PathVariable String phone) {
        return ResponseEntity.ok(userService.findByPhone(phone));
    }

    @GetMapping(value = "/person/{lastname}")
    public ResponseEntity<User> getByLastname(@PathVariable String lastname) {
        return ResponseEntity.ok(userService.findByLastName(lastname));
    }

    @PostMapping(value = "/persons")
    public ResponseEntity<User> create(@RequestBody User user) {
        return ResponseEntity.ok(user);
    }
}
