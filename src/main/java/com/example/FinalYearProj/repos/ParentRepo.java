package com.example.FinalYearProj.repos;

import com.example.FinalYearProj.entities.ParentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepo extends JpaRepository<ParentEntity , Long> {
}
