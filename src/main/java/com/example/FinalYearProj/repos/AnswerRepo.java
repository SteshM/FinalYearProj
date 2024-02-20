package com.example.FinalYearProj.repos;

import com.example.FinalYearProj.entities.AnswerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepo extends JpaRepository<AnswerEntity , Long> {
}
