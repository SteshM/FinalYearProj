package com.example.FinalYearProj.repos;

import com.example.FinalYearProj.entities.LevelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface LevelRepo extends JpaRepository<LevelEntity, Long> {
    LevelEntity findBylevelId(long levelId);
}
