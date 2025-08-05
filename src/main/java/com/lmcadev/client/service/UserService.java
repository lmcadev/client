package com.lmcadev.client.service;

import com.lmcadev.client.DTO.UserDTORequest;
import com.lmcadev.client.DTO.UserDTOResponse;
import com.lmcadev.client.model.User;
import com.lmcadev.client.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.stream.StreamSupport;

@Service
public class UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }




    public UserDTOResponse createUser(UserDTORequest request) {

        if(request.getUsername() == null || request.getUsername().trim().isEmpty()){
            throw new IllegalArgumentException("El usuario no puede estar vacío");
        }
        if(request.getPassword() == null || request.getPassword().trim().isEmpty()){
            throw new IllegalArgumentException("La contraseña no puede estar vacía");
        }
        if(request.getEmail() == null || request.getEmail().trim().isEmpty()){
            throw new IllegalArgumentException("El email no puede estar vacío");
    }
        if(request.getFirstName() == null || request.getFirstName().trim().isEmpty()){
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());

        User save = userRepository.save(user);

        UserDTOResponse response = new UserDTOResponse();
        response.setId(save.getId());
        response.setUsername(save.getUsername());
        response.setEmail(save.getEmail());
        response.setFirstName(save.getFirstName());
        response.setLastName(save.getLastName());

        return response;
    }

    public UserDTOResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado con ID: " + id));

        UserDTOResponse response = new UserDTOResponse();
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());

        return response;
    }

    public Iterable<UserDTOResponse> getAllUsers() {
        Iterable<User> users = userRepository.findAll();
        return StreamSupport.stream(users.spliterator(), false).map(user -> {
            UserDTOResponse response = new UserDTOResponse();
            response.setId(user.getId());
            response.setUsername(user.getUsername());
            response.setEmail(user.getEmail());
            response.setFirstName(user.getFirstName());
            response.setLastName(user.getLastName());
            return response;
        }).toList();
    }
}
