package com.example.FinalYearProj.controller;

import com.example.FinalYearProj.dto.ResponseDTO;
import com.example.FinalYearProj.dto.UserDTO;
import com.example.FinalYearProj.dto.UserTypeDTO;
import com.example.FinalYearProj.services.UserServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("v1/user")
public class UserController {
    @Autowired
    UserServices userServices;
    @GetMapping("/hello")
    public String welcome(){
        return "hello enjoy our services";
    }

    @PostMapping("/register/")
    public ResponseDTO register(@RequestBody UserDTO userDTO){
        log.info("Received a request  to register a user. Payload received:{}",userDTO);
        return userServices.register(userDTO);
    }
    @PostMapping("/login")
    public ResponseDTO login(UserDTO userDTO){
        return userServices.login(userDTO);
    }
    @PostMapping("/create-User-Types")
    public ResponseDTO createUserType(@RequestBody UserTypeDTO userTypeDTO){
        return userServices.createUserTypes(userTypeDTO);
    }
    @GetMapping("/get-User-Types")
    public ResponseDTO getUserTypes(){
        return userServices.fetchUserTypes();
    }



}
