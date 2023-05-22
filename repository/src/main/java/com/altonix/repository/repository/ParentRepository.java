package com.altonix.repository.repository;

import com.altonix.repository.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ParentRepository extends JpaRepository<Parent, Long> {
    // TODO: 5/23/2023 Delete class
    List<Parent> findAll();

    Optional<Parent> findByName(String name);
}
