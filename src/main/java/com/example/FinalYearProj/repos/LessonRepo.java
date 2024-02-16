package com.example.FinalYearProj.repos;

import com.example.FinalYearProj.entities.LessonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepo extends JpaRepository<LessonEntity , Long> {
}
