package com.example.security.component;

import com.example.model.Student;
import com.example.repo.AcountRepository;
import com.example.repo.StudentRepo;
import com.example.security.Acount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class UserSecurity {

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    AcountRepository accountRepository;

    public boolean checkUserId(Authentication authentication,Long idStudent) {
        String username =   authentication.getName();
        Acount account = accountRepository.findByUsername(username);
        Student cond = studentRepo.findById(account.getId()).get();
        return cond.getIdStudent().equals(idStudent);
    }

    public Long getUserId(Authentication authentication) {
        String username =   authentication.getName();
        Acount account = accountRepository.findByUsername(username);
        Student cond = studentRepo.findByAccountId(account.getId());
        return cond.getIdStudent();
    }


}