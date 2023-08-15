package com.example.service;

import com.example.exceptions.SkillWithSameNameAlreadyExist;
import com.example.model.Skill;

public interface SkillsService {
    public void addSkillToStident(Long idStudent,Long idSkill);
    public Skill findByName(String name);
    public void save(Skill skill) throws SkillWithSameNameAlreadyExist;
}
