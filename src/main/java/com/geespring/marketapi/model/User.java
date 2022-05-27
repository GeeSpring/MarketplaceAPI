package com.geespring.marketapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    /**
     * Represents the sql id for this customer's account
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(name = "created_at", nullable = false, updatable = false)
    private String createdAt;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
