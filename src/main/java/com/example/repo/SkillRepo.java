package com.example.repo;

import com.example.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepo extends JpaRepository<Skill,Long> {

    Skill findByName(String name);
}
