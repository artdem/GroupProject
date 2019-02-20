package com.example.demo.repositores;

import com.example.demo.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();

    List<User> getAllByRole(String role);

    Optional<User> findByLogin(String login);

}
