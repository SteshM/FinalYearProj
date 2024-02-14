package com.example.FinalYearProj.services;

import com.example.FinalYearProj.Utilities.Utilities;
import com.example.FinalYearProj.dto.ResponseDTO;
import com.example.FinalYearProj.dto.UserDTO;
import com.example.FinalYearProj.dto.UserTypeDTO;
import com.example.FinalYearProj.entities.UserEntity;
import com.example.FinalYearProj.entities.UserTypeEntity;
import com.example.FinalYearProj.repos.UserRepo;
import com.example.FinalYearProj.repos.UserTypeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServices {
 @Autowired
 UserRepo userRepo;
 UserTypeRepo userTypeRepo;

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

    public ResponseDTO createUserTypes(UserTypeDTO userTypeDTO) {
        UserTypeEntity userTypeEntity = new UserTypeEntity();
        userTypeEntity.setUserTypeId(userTypeDTO.getUserTypeId());
        userTypeEntity.setUserTypeName(userTypeDTO.getUserTypeName());
        UserTypeEntity createdUserType = userTypeRepo.save(userTypeEntity);
        return Utilities.createSuccessfulResponse("Successfully created a UserType",createdUserType);
    }
}
