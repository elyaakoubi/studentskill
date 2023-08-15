package com.example.service;

import com.example.exceptions.SkillWithSameNameAlreadyExist;
import com.example.model.Skill;
import com.example.model.Student;
import com.example.repo.SkillRepo;
import com.example.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class SkilServiceImpl implements SkillsService{

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private SkillRepo skillRepo;

    @Transactional
    @Override
    public void addSkillToStident(Long idStudent, Long idSkill) {
        Optional<Student> std = studentRepo.findById(idStudent);
        Optional<Skill> skl = skillRepo.findById(idSkill);

        if(std.isPresent() && skl.isPresent())
        {
            Student st = std.get();
            Skill sk = skl.get();
            st.getSkills().add(sk);
            studentRepo.save(st);
        }
        else if(std.isEmpty())
            throw new EntityNotFoundException("Student doesn't existe id: " + idStudent);
        else if(skl.isEmpty())
            throw new EntityNotFoundException("Skill doesn't existe id: " + idSkill);
    }

    @Override
    public Skill findByName(String name) {
        return skillRepo.findByName(name);
    }

    @Override
    public void save(Skill skill) throws SkillWithSameNameAlreadyExist {
        Skill s = skillRepo.findByName(skill.getName());
        if(s==null)
        skillRepo.save(skill);
        else
            throw new SkillWithSameNameAlreadyExist(  "Skill with name: " +
                    skill.getName() +
                    " already exist..");
    }
}
