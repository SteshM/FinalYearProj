package com.example.FinalYearProj.services;

import com.example.FinalYearProj.Utilities.Utilities;
import com.example.FinalYearProj.dto.*;
import com.example.FinalYearProj.entities.*;
import com.example.FinalYearProj.repos.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ResourceServices {

  private static LevelRepo levelRepo;
  private static GradeRepo gradeRepo;
  private static SubjectRepo subjectRepo;
  private static LessonRepo lessonRepo;
  private static TopicRepo topicRepo;
  private static ContentRepo contentRepo;

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
        GradeEntity gradeEntity = gradeRepo.findById(gradeId).get();
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

    public static ResponseDTO getSubjectById(long subjectId) {
        SubjectEntity subjectEntity = subjectRepo.findById(subjectId).get();
        return Utilities.createSuccessfulResponse("Successfully fetched a subject by its Id", subjectEntity);

    }

    public static ResponseDTO createLesson(LessonDTO lessonDTO) {
        LessonEntity lessonEntity = new LessonEntity();
        lessonEntity.setLessonName(lessonDTO.getLessonName());
        lessonEntity.setLessonDescription(lessonDTO.getLessonDescription());
        lessonEntity.setDuration(lessonDTO.getDuration());
        LessonEntity createdLesson = lessonRepo.save(lessonEntity);
        return  Utilities.createSuccessfulResponse("Successfully created a lesson", createdLesson);
    }

    public static ResponseDTO getLessons() {
       List<LessonEntity>  lessonEntityList = lessonRepo.findAll();
       return Utilities.createSuccessfulResponse("Successfully fetched all lessons",lessonEntityList);
    }

    public static ResponseDTO getLessonById(long lessonId) {
        LessonEntity lessonEntity = lessonRepo.findById(lessonId).get();
        return Utilities.createSuccessfulResponse("Successfully fetched a lesson",lessonEntity);
    }

    public static ResponseDTO createTopic(TopicDTO topicDTO) {
        TopicEntity topicEntity = new TopicEntity();
        topicEntity.setTopicName(topicDTO.getTopicName());
        TopicEntity createdTopic = topicRepo.save(topicEntity);
        return Utilities.createSuccessfulResponse("Successfully created a topic",createdTopic);
    }

    public static ResponseDTO getTopics() {
        List<TopicEntity>topicEntityList = topicRepo.findAll();
        return Utilities.createSuccessfulResponse("Successfully fetched all topics",topicEntityList);
    }

    public static ResponseDTO getTopicById(long topicId) {
        TopicEntity topicEntity = topicRepo.findById(topicId).get();
        return Utilities.createSuccessfulResponse("Successfully fetched topic by Id",topicEntity);
    }

    public static ResponseDTO createContent(ContentDTO contentDTO) {
        ContentEntity contentEntity = new ContentEntity();
        contentEntity.setContentUrl(contentDTO.getContentUrl());
        contentEntity.setContentDescription(contentDTO.getContentDescription());
        ContentEntity createdContent = contentRepo.save(contentEntity);
        return Utilities.createSuccessfulResponse("Successfully created content",createdContent);
    }

    public static ResponseDTO getContent() {
        List<ContentEntity> contentEntityList = contentRepo.findAll();
        return Utilities.createSuccessfulResponse("successfully fetched content",contentEntityList);
    }

    public static ResponseDTO getContentById(long contentId) {
        ContentEntity contentEntity = contentRepo.findById(contentId).get();
        return Utilities.createSuccessfulResponse("successfully fetched content by Id",contentEntity);
    }
}
