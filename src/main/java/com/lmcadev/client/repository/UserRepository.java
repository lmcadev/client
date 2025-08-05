package com.lmcadev.client.repository;

import com.lmcadev.client.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    Optional<User> findByUsernameOrEmail(String username, String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByUsernameOrEmail(String username, String email);
    boolean existsById(Long id);
    void deleteById(Long id);
    void deleteByUsername(String username);
    void deleteByEmail(String email);
    void deleteByUsernameOrEmail(String username, String email);
    void deleteAllByIdIn(Iterable<Long> ids);
    void deleteAllByUsernameIn(Iterable<String> usernames);
    List<User> findAllByUsernameIn(Iterable<String> usernames);


}
