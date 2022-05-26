package com.geespring.marketapi.controller;

import com.geespring.marketapi.model.Account;
import com.geespring.marketapi.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "customer")
@RequiredArgsConstructor
public class AccountController {

    /**
     * Represents the Customer Service Provider
     */
    @Autowired
    private final AccountService service;

    /**
     * Handles the post mapping to create an account and store into the database.
     * @param account
     * @return the account object that was requested
     */
    @PostMapping("/")
    public ResponseEntity<Account> create(@RequestBody Account account) {
        return new ResponseEntity<>(service.create(account), HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles the get mapping to find the account associated with the requested id
     * @param id
     * @return the account object
     */
    @GetMapping("/{id}")
    public ResponseEntity<Account> find(@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.find(id), HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles the delete mapping to delete the account with the requested account id
     * @param id
     * @return http status ok
     */
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
