package com.example.FinalYearProj.repos;

import com.example.FinalYearProj.entities.TopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepo extends JpaRepository<TopicEntity , Long> {
}
