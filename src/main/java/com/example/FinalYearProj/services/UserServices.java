package com.example.FinalYearProj.services;

import com.example.FinalYearProj.Utilities.Utilities;
import com.example.FinalYearProj.dto.ResponseDTO;
import com.example.FinalYearProj.dto.UserDTO;
import com.example.FinalYearProj.entities.UserEntity;
import com.example.FinalYearProj.repos.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServices {
 @Autowired
 UserRepo userRepo;

    public ResponseDTO register(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userDTO.getName());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setDateOfBirth(userDTO.getDateOfBirth());
        UserEntity createdUser = userRepo.save(userEntity);
        return Utilities.createSuccessfulResponse("Successfully created a user",createdUser
        );
    }

}
