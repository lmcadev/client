package com.lmcadev.client.controller;

import com.lmcadev.client.DTO.UserDTORequest;
import com.lmcadev.client.DTO.UserDTOResponse;
import com.lmcadev.client.model.User;
import com.lmcadev.client.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDTOResponse> createUser(@RequestBody @Valid UserDTORequest userDTORequest) {
        UserDTOResponse userDTOResponse = userService.createUser(userDTORequest);
        return ResponseEntity.ok(userDTOResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTOResponse> getUserById(@PathVariable Long id) {
        UserDTOResponse userDTOResponse = userService.getUserById(id);
        return ResponseEntity.ok(userDTOResponse);
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<UserDTOResponse>> getAllUsers() {
        Iterable<UserDTOResponse> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

}


