package com.example.service;

import com.example.model.Student;

import java.util.List;

public interface StudentService {
    public Student findById(Long idStudent);
    public List<Student> findAll();
}
