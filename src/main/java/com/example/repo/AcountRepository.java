package com.example.repo;

import com.example.security.Acount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcountRepository extends JpaRepository<Acount,Long> {

    public Acount findByUsername(String username);
}
