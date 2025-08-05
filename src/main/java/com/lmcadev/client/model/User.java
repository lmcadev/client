package com.lmcadev.client.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;
import lombok.ToString;


@Entity
@Getter @Setter
@EqualsAndHashCode(exclude = "password")
@ToString(exclude = "password")
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull
    private String username;

    @NotNull
    @Column(nullable = false)
    @Size(min = 8)
    private String password;

    @NotNull
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @Size(max = 20)
    private String firstName;

    @Size(max = 20)
    private String lastName;

}
