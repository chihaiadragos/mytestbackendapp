package com.example.mytestbackendapp.controller;

import com.example.mytestbackendapp.entity.Person;
import com.example.mytestbackendapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<Person> save(@RequestBody Person person) {
        return new ResponseEntity<>(personService.save(person), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getUser(@PathVariable Long id) {
        Person foundUser = personService.getPerson(id);
        return foundUser == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(foundUser, HttpStatus.OK);
    }
}
