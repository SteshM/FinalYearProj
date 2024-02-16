package com.example.FinalYearProj.controller;

import com.example.FinalYearProj.dto.GradeDTO;
import com.example.FinalYearProj.dto.LevelDTO;
import com.example.FinalYearProj.dto.ResponseDTO;
import com.example.FinalYearProj.dto.SubjectDTO;
import com.example.FinalYearProj.services.ResourceServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/resource")
public class ResourceController {
    @PostMapping("/level")
    public ResponseDTO createLevel(@RequestBody LevelDTO levelDTO){
        log.info("Received a payload to create a level.payload received:{}",levelDTO);
        return ResourceServices.createLevel(levelDTO);
    }
    @GetMapping("/getlevel{levelId}")
    public ResponseDTO getLevelById(@PathVariable long levelId){
        return ResourceServices.getLevelById(levelId);
    }
    @GetMapping("/levels")
    public ResponseDTO getLevels(){
        return ResourceServices.getLevels();
    }
    @PostMapping("/grade")
    public ResponseDTO createGrade(@RequestBody GradeDTO gradeDTO){
        return ResourceServices.createGrade(gradeDTO);
    }
    @GetMapping("/getGrade{gradeId}")
    public ResponseDTO getGradeById(@PathVariable long gradeId){
        return ResourceServices.getGradeById(gradeId);
    }
    @GetMapping("/grades")
    public ResponseDTO getGrades(){
        return ResourceServices.getGrades();
    }
@PostMapping("/createSubject")
    public ResponseDTO createSubject(@RequestBody SubjectDTO subjectDTO){
        return ResourceServices.createSubject(subjectDTO);
}
@GetMapping("/subjects")
    public ResponseDTO getSubjects(){
        return ResourceServices.getSubjects();
}
}
