package com.toluwase.appbackend.repositories;

import com.toluwase.appbackend.models.Todos;
import com.toluwase.appbackend.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodosRepository extends JpaRepository<Todos, Long> {
    List<Todos> findAllByUsers(Users users);
}
