package com.example.FinalYearProj.repos;

import com.example.FinalYearProj.entities.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepo extends JpaRepository<QuestionEntity , Long> {
}
