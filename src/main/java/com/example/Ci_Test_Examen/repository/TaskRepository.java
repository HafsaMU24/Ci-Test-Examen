package com.example.Ci_Test_Examen.repository;


import com.example.Ci_Test_Examen.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
