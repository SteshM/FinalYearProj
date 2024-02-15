package com.example.FinalYearProj.controller;

import com.example.FinalYearProj.dto.LevelDTO;
import com.example.FinalYearProj.dto.ResponseDTO;
import com.example.FinalYearProj.services.ResourceServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/Resource")
public class ResourceController {
    @PostMapping("/level")
    public ResponseDTO createLevel(@RequestBody LevelDTO levelDTO){
        log.info("Received a payload to create a level.payload received:{}",levelDTO);
        return ResourceServices.createLevel(levelDTO);
    }
}
