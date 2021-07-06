package com.toluwase.appbackend.repositories;

import com.toluwase.appbackend.models.Todos;
import com.toluwase.appbackend.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodosRepository extends JpaRepository<Todos, Long> {

}
