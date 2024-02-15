package com.example.FinalYearProj.repos;

import com.example.FinalYearProj.entities.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepo extends JpaRepository<SubjectEntity , Long> {

}
