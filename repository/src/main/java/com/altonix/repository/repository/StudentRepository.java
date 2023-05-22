package com.altonix.repository.repository;

import com.altonix.repository.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // TODO: 5/23/2023 Delete class
    List<Student> findAll();

    Optional<Student> findByName(String name);
}
