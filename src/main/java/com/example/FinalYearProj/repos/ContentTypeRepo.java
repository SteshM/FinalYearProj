package com.example.FinalYearProj.repos;

import com.example.FinalYearProj.entities.ContentTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentTypeRepo extends JpaRepository<ContentTypeEntity , Long> {
}
