package com.example.Ci_Test_Examen.repository;

import com.example.Ci_Test_Examen.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User,Long> {
}
