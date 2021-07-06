package com.toluwase.appbackend.repositories;

import com.toluwase.appbackend.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findUserByFirstName(String name);
    Users findByUsernameAndPassword(String username, String password);
    Users findByEmailAndPassword(String email, String password);
    Optional<Users> findById(Long id);
}
