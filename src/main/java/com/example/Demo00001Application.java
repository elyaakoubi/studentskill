package com.example;

import com.example.model.Skill;
import com.example.model.Student;
import com.example.repo.SkillRepo;
import com.example.repo.StudentRepo;
import com.example.security.Acount;
import com.example.security.Role;
import com.example.service.IaccountService;
import com.example.service.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashSet;

@SpringBootApplication
public class Demo00001Application implements CommandLineRunner {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private SkillRepo skillRepo;

    @Autowired
    private SkillsService skillsService;

    @Autowired
    private IaccountService acountService;

    public static void main(String[] args) {
        SpringApplication.run(Demo00001Application.class, args);
        System.out.println("----------------");
    }

    @Override
    public void run(String... args) throws Exception {
/*
        Student st = Student.builder()
                .name("Naoufal")
                .skills(new HashSet<>())
                .build();

        Skill sk = Skill.builder()
                .name("java")
                .build();

        Skill sk2 = Skill.builder()
                .name("java")
                .build();


        skillRepo.save(sk);
        studentRepo.save(st);


        acountService.addNewRole(new Role(null,"ADMIN"));
        acountService.addNewRole(new Role(null,"ETUDIANT"));


        Acount account1 = Acount.builder()
                .username("etudiant1")
                .password("1111")
                .build();
        acountService.addNewAccount(account1);

        acountService.addRoleToAccount("etudiant1","ETUDIANT");

*/
        System.out.println("...........................");




    }
}
