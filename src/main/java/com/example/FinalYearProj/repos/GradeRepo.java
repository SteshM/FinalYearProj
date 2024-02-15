package com.example.FinalYearProj.repos;

import com.example.FinalYearProj.entities.GradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepo extends JpaRepository<GradeEntity , Long> {
}
