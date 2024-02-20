package com.example.FinalYearProj.controller;

import com.example.FinalYearProj.dto.*;
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
    @GetMapping("/getLevel{levelId}")
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
@GetMapping("/getSubject{subjectId}")
    public ResponseDTO getSubjectById(@PathVariable long subjectId){
        return ResourceServices.getSubjectById(subjectId);
}
@PostMapping("/createLesson")
    public ResponseDTO createLesson(@RequestBody LessonDTO lessonDTO){
        return ResourceServices.createLesson(lessonDTO);
}
@GetMapping("/lessons")
    public ResponseDTO getLessons(){
        return ResourceServices.getLessons();
}
@GetMapping("/getLesson{lessonId}")
    public ResponseDTO getLessonsById(@PathVariable long lessonId){
        return ResourceServices.getLessonById(lessonId);
}
@PostMapping("/createTopic")
    public ResponseDTO createTopic(@RequestBody TopicDTO topicDTO){
        return ResourceServices.createTopic(topicDTO);
}
@GetMapping("/topics")
    public ResponseDTO getTopics(){
        return ResourceServices.getTopics();
}
@GetMapping("/getTopic{topicId}")
public ResponseDTO getTopicById(@PathVariable long topicId){
        return ResourceServices.getTopicById(topicId);
}
@PostMapping("/createContent")
    public ResponseDTO createContent(@RequestBody ContentDTO contentDTO){
        return ResourceServices.createContent(contentDTO);
}
@GetMapping("/content")
    public ResponseDTO getContent(){
        return ResourceServices.getContent();
}
@GetMapping("/getContent{contentId}")
    public ResponseDTO getContentById(@PathVariable long contentId){
        return ResourceServices.getContentById(contentId);
}
@PostMapping("/createContentType")
    public ResponseDTO createContentType(@RequestBody ContentTypeDTO contentTypeDTO){
        return ResourceServices.createContentType(contentTypeDTO);
}
@GetMapping("/contentTypes")
    public ResponseDTO getContentTypes(){
        return ResourceServices.getContentTypes();
}

@PostMapping("/createHomeWork")
    public ResponseDTO createHomeWork(HomeWorkDTO homeWorkDTO){
        return ResourceServices.createHomework(homeWorkDTO);
}
@GetMapping("/HomeWorks")
    public ResponseDTO getHomeWorks(){
        return ResourceServices.getHomeWorks();
}

@PutMapping("/homeWork/{id}")
    public ResponseDTO updateHomeWork(@PathVariable long id, @RequestBody HomeWorkDTO homeWorkDTO){
        return ResourceServices.updateHomeWork(id , homeWorkDTO);
}
@DeleteMapping ("/homeWork/{id}")
    public ResponseDTO delete(@PathVariable long id ){
        return ResourceServices.deleteById(id);
}

    @PostMapping("/createQuestion")
    public ResponseDTO createQuestion(@RequestBody QuestionDTO questionDTO){
        return ResourceServices.createQuestion(questionDTO);
    }
}

