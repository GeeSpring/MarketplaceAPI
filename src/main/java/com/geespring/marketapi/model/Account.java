package com.geespring.marketapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Account {

    /**
     * Represents the sql id for this customer's account
     */
    private Long id;

    /**
     * Represents the customer's full name
     */
    @NonNull
    private String name;

    /**
     * Represents the customer's email address
     */
    @NonNull
    private String email;

    /**
     * Represents the password associated with the customers account
     */
    @NonNull
    private String password;

    /**
     * Constructor used to create a basic Customer Account
     * @param id
     * @param name
     * @param email
     */
    public Account(final long id, @NonNull final String name, @NonNull final String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

}
