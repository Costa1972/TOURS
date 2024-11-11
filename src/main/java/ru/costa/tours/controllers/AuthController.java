package ru.costa.tours.controllers;



import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.costa.tours.models.User;
import ru.costa.tours.services.UserService;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;


    @GetMapping(value = "/auth/signin")
    public String greeting(Authentication authentication) {
        String name = authentication.getName();
        return "Welcome " + name + "!";
    }

    @PostMapping(value = "/auth/signup")
    public ResponseEntity<User> signup(@RequestBody User user) {
        userService.addOrEdit(user);
        return ResponseEntity.ok(user);
    }
}
