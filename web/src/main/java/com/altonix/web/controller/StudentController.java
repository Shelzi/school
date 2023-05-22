package com.altonix.web.controller;

import com.altonix.repository.entity.Parent;
import com.altonix.repository.entity.Student;
import com.altonix.repository.repository.ParentRepository;
import com.altonix.repository.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {
    // TODO: 5/23/2023 Delete class
    private final StudentRepository studentRepository;
    private final ParentRepository parentRepository;

    @GetMapping("/students")
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("students/{name}")
    public Student findStudentByName(@PathVariable String name) {
        return studentRepository.findByName(name).orElse(null);
    }

    @GetMapping("/parents")
    public List<Parent> findAllParents() {
        return parentRepository.findAll();
    }

    @GetMapping("parents/{name}")
    public Parent findParentByName(@PathVariable String name) {
        return parentRepository.findByName(name).orElse(null);
    }
}
