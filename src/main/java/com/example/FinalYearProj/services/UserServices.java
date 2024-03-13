package com.example.FinalYearProj.services;

import com.example.FinalYearProj.Utilities.Utilities;
import com.example.FinalYearProj.dto.ResponseDTO;
import com.example.FinalYearProj.dto.UserDTO;
import com.example.FinalYearProj.dto.UserTypeDTO;
import com.example.FinalYearProj.entities.*;
import com.example.FinalYearProj.repos.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.usertype.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserServices {
 @Autowired
 UserRepo userRepo;
 StudentRepo studentRepo;
 TutorRepo tutorRepo;
 ParentRepo parentRepo;
 UserTypeRepo userTypeRepo;



    public ResponseDTO register(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userDTO.getName());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setDateOfBirth(userDTO.getDateOfBirth());
        if(userDTO.getWho().equalsIgnoreCase("Student")){
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setAdmissionNo(userDTO.getAdmNo());
            studentRepo.save(studentEntity);
        }
        else if (userDTO.getWho().equalsIgnoreCase("Tutor")){
            TutorEntity tutorEntity = new TutorEntity();
            tutorEntity.setEmploymentNo(userDTO.getEmploymentNo());
            tutorEntity.setTutorContact(userDTO.getTutorContact());
            tutorEntity.setTutorIdNo(userDTO.getTutorIdNo());
            tutorRepo.save(tutorEntity);
        }
        else if(userDTO.getWho().equalsIgnoreCase("Parent")){
            ParentEntity parentEntity = new ParentEntity();
            parentEntity.setParentIdNo(userDTO.getParentIdNo());
            parentEntity.setParentContact(userDTO.getParentContact());
            parentRepo.save(parentEntity);
        }

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

    public ResponseDTO fetchUserTypes() {
        List<UserTypeEntity> userTypes = userTypeRepo.findAll();
        List<UserTypeDTO> userTypeDTOList = new ArrayList<>();

        userTypes.forEach(
                userTypeEntity -> {
                    UserTypeDTO userTypeDTO = new UserTypeDTO();
                    userTypeDTO.setUserTypeId(userTypeEntity.getUserTypeId());
                    userTypeDTO.setUserTypeName(userTypeEntity.getUserTypeName());
                    userTypeDTOList.add(userTypeDTO);
                }

        );
        log.info("Get {} user types", userTypeDTOList.size());
        return Utilities.createSuccessfulResponse("successfully fetched user types", userTypeDTOList);



    }
}
