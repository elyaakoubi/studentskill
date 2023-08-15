package com.example.repo;

import com.example.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {

    @Query("SELECT s FROM Student s WHERE s.account.id = :accountId")
    Student findByAccountId(@Param("accountId") Long accountId);
}
