package ru.costa.tours.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.costa.tours.models.Person;
import ru.costa.tours.services.PersonService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping(value = "/persons")
    public ResponseEntity<List<Person>> getAll() {
        return ResponseEntity.ok(personService.findAll());
    }

    @GetMapping(value = "/person/{id}")
    public ResponseEntity<Person> getById(@PathVariable Long id) {
        return ResponseEntity.ok(personService.findById(id));
    }

    @GetMapping(value = "/person/{phone}")
    public ResponseEntity<Person> getByPhone(@PathVariable String phone) {
        return ResponseEntity.ok(personService.findByPhone(phone));
    }

    @GetMapping(value = "/person/{lastname}")
    public ResponseEntity<Person> getByLastname(@PathVariable String lastname) {
        return ResponseEntity.ok(personService.findByLastName(lastname));
    }

    @PostMapping(value = "/persons")
    public ResponseEntity<Person> create(@RequestBody Person person) {
        return ResponseEntity.ok(person);
    }
}
