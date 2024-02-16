package com.example.FinalYearProj.services;

import com.example.FinalYearProj.Utilities.Utilities;
import com.example.FinalYearProj.dto.GradeDTO;
import com.example.FinalYearProj.dto.LevelDTO;
import com.example.FinalYearProj.dto.ResponseDTO;
import com.example.FinalYearProj.dto.SubjectDTO;
import com.example.FinalYearProj.entities.GradeEntity;
import com.example.FinalYearProj.entities.LevelEntity;
import com.example.FinalYearProj.entities.SubjectEntity;
import com.example.FinalYearProj.repos.GradeRepo;
import com.example.FinalYearProj.repos.LevelRepo;
import com.example.FinalYearProj.repos.SubjectRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ResourceServices {

  private static LevelRepo levelRepo;
  private static GradeRepo gradeRepo;
  private static SubjectRepo subjectRepo;

    public static ResponseDTO createLevel(LevelDTO levelDTO) {
        LevelEntity levelEntity = new LevelEntity();
        levelEntity.setLevelName(levelDTO.getLevelName());
        levelEntity.setLevelDescription(levelDTO.getLevelDescription());
        LevelEntity createdLevel = levelRepo.save(levelEntity);
        return Utilities.createSuccessfulResponse("successfully created a level",createdLevel);
    }

    public static ResponseDTO getLevelById(long levelId) {
        LevelEntity levelEntity = levelRepo.findBylevelId(levelId);
                return Utilities.createSuccessfulResponse("successfully retrieved levels",levelEntity);


    }

    public static ResponseDTO getLevels() {
        List<LevelEntity> levelEntityList = levelRepo.findAll();
        return Utilities.createSuccessfulResponse("successfully fetched all levels",levelEntityList);
    }

    public static ResponseDTO createGrade(GradeDTO gradeDTO) {
        GradeEntity gradeEntity = new GradeEntity();
        gradeEntity.setGradeName(gradeDTO.getGradeName());
        GradeEntity createdGrade = gradeRepo.save(gradeEntity);
        return Utilities.createSuccessfulResponse("Successfully created Grade",createdGrade);

    }

    public static ResponseDTO getGradeById(long gradeId) {
        GradeEntity gradeEntity = gradeRepo.FindByGradeId(gradeId);
        return Utilities.createSuccessfulResponse("Successfully fetched one grade",gradeEntity);
    }

    public static ResponseDTO getGrades() {
        List<GradeEntity> gradeEntityList = gradeRepo.findAll();
        return Utilities.createSuccessfulResponse("Successfully fetched all grades",gradeEntityList);
    }

    public static ResponseDTO createSubject(SubjectDTO subjectDTO) {
        SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setSubjectName(subjectDTO.getSubjectName());
        SubjectEntity createdSubject = subjectRepo.save(subjectEntity);
        return Utilities.createSuccessfulResponse("Successfully created a subject",createdSubject);
    }

    public static ResponseDTO getSubjects() {
        List<SubjectEntity>subjectEntityList = subjectRepo.findAll();
        return Utilities.createSuccessfulResponse("Successfully fetched all subjects",subjectEntityList);
    }
}
