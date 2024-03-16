package com.example.FinalYearProj.repos;

import com.example.FinalYearProj.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity , Long> {

    UserEntity findByEmail(String email);
}
