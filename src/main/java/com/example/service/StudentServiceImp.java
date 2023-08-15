package com.example.service;

import com.example.model.Student;
import com.example.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImp implements StudentService{

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Student findById(Long idStudent) {
        Optional<Student> optstd = studentRepo.findById(idStudent);
        if(optstd.isPresent())
        return optstd.get();
        throw new EntityNotFoundException("Student doesn't existe id: " + idStudent);
    }

    @Override
    public List<Student> findAll() {
        return studentRepo.findAll();
    }
}
