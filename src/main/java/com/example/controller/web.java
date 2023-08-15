package com.example.controller;

import com.example.exceptions.SkillWithSameNameAlreadyExist;
import com.example.model.Skill;
import com.example.model.Student;
import com.example.service.SkillsService;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class web {
    @Autowired
    private SkillsService skillsService;
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    @PreAuthorize("hasAuthority('ETUDIANT')")
    public List<Student> getAllStudents(){
        return studentService.findAll();
    }

    @GetMapping("/student/{idStudent}")
    public Student getStudent(@PathVariable("idStudent") Long idStudent){
        return studentService.findById(idStudent);
    }

    @PostMapping("/studentskill")
    public void setStudentSkil(@RequestParam("idstud") Long idstud,
                               @RequestParam("idsk") Long idsk){
        skillsService.addSkillToStident(idstud,idsk);
    }
    @PostMapping("/skill")
    public void saveSkill(@RequestParam("name") String name)
            throws SkillWithSameNameAlreadyExist {
        Skill s = Skill.builder()
                .name(name)
                .build();
        skillsService.save(s);
    }
}
