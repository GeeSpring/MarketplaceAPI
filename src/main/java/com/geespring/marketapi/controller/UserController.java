package com.geespring.marketapi.controller;

import com.geespring.marketapi.model.User;
import com.geespring.marketapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "users")
@RequiredArgsConstructor
public class UserController {

    /**
     * Represents the Customer Service Provider
     */
    @Autowired
    private final UserService service;

    /**
     * Handles the post mapping to create an account and store into the database.
     * @param user
     * @return the account object that was requested
     */
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        return new ResponseEntity<>(service.create(user), HttpStatus.OK);
    }

    /**
     * Handles the get mapping to find the account associated with the requested id
     * @param id
     * @return the account object
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> find(@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.find(id), HttpStatus.OK);
    }

    /**
     * Handles the delete mapping to the account with the requested account id
     * @param id
     * @return {@link HttpStatus#OK}
     */
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
