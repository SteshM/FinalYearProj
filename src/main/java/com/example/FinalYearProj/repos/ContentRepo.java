package com.example.FinalYearProj.repos;

import com.example.FinalYearProj.entities.ContentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepo extends JpaRepository<ContentEntity , Long> {

}
