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
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class UserServices implements UserDetailsService {
 @Autowired
 UserRepo userRepo;
 @Autowired
 StudentRepo studentRepo;
 @Autowired
 TutorRepo tutorRepo;
 @Autowired
 ParentRepo parentRepo;
 @Autowired
 UserTypeRepo userTypeRepo;
 @Autowired
    PasswordEncoder passwordEncoder;
 @Autowired
 TokenGenerator tokenGenerator;





    public ResponseDTO register(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userDTO.getName());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userEntity.setDateOfBirth(userDTO.getDateOfBirth());
        if(userDTO.getWho().equalsIgnoreCase("Student")){
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setAdmissionNo(userDTO.getAdmNo());
            userEntity.setRole("Student");
            studentRepo.save(studentEntity);
        }
        else if (userDTO.getWho().equalsIgnoreCase("Tutor")){
            TutorEntity tutorEntity = new TutorEntity();
            tutorEntity.setEmploymentNo(userDTO.getEmploymentNo());
            tutorEntity.setTutorContact(userDTO.getTutorContact());
            tutorEntity.setTutorIdNo(userDTO.getTutorIdNo());
            userEntity.setRole("Tutor");
            tutorRepo.save(tutorEntity);
        }
        else if(userDTO.getWho().equalsIgnoreCase("Parent")){
            ParentEntity parentEntity = new ParentEntity();
            parentEntity.setParentIdNo(userDTO.getParentIdNo());
            parentEntity.setParentContact(userDTO.getParentContact());
            userEntity.setRole("Parent");
            parentRepo.save(parentEntity);
        }

        UserEntity createdUser = userRepo.save(userEntity);
        return Utilities.createSuccessfulResponse("Successfully created a user",createdUser
        );
    }
    public ResponseDTO login(UserDTO userDTO){
        UserEntity user = userRepo.findByEmail(userDTO.getEmail());
        if (user == null){
            return Utilities.createFailedResponse(404L,"User not found");
        }
        else{
            if (passwordEncoder.matches(userDTO.getPassword(),user.getPassword())){
                Collection<SimpleGrantedAuthority>authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority(user.getRole()));
                        User user1 = new User(user.getEmail(),user.getPassword(),authorities);
                 Map<String,String> res = new HashMap<>();
                 res.put("token",tokenGenerator.token(user1));
                 res.put("email",userDTO.getEmail());
                 return Utilities.createSuccessfulResponse("successfully logged in",res);
            }
            else {
                return Utilities.createFailedResponse(404L,"Password Mismatch");
            }
        }
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
