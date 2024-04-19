package com.example.mytestbackendapp.repository;

import com.example.mytestbackendapp.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
