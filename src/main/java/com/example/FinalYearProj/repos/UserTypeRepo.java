package com.example.FinalYearProj.repos;

import com.example.FinalYearProj.entities.UserTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTypeRepo extends JpaRepository<UserTypeEntity,Long> {
}
