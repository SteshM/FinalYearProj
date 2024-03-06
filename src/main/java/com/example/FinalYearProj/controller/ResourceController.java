package com.example.FinalYearProj.controller;

import com.example.FinalYearProj.dto.*;
import com.example.FinalYearProj.services.ResourceServices;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/resource")
public class ResourceController {
    @Autowired
    ResourceServices resourceServices;

    @GetMapping("/get-Level/{levelId}")
    public ResponseDTO getLevelById(@PathVariable long levelId){
        return resourceServices.getLevelById(levelId);
    }
    @GetMapping("/levels")
    public ResponseDTO getLevels(){
        return resourceServices.getLevels();
    }

    @GetMapping("/get-Grade/{gradeId}")
    public ResponseDTO getGradeById(@PathVariable long gradeId){
        return resourceServices.getGradeById(gradeId);
    }
    @GetMapping("/grades")
    public ResponseDTO getGrades(){
        return resourceServices.getGrades();
    }

    @PutMapping("/grade/{id}")
    public ResponseDTO updateGrade(@PathVariable long id , @RequestBody GradeDTO gradeDTO){
        return resourceServices.updateGrade(id , gradeDTO);
    }


@GetMapping("/subjects")
    public ResponseDTO getSubjects(){
        return resourceServices.getSubjects();
}
@GetMapping("/get-Subject/{subjectId}")
    public ResponseDTO getSubjectById(@PathVariable long subjectId){
        return resourceServices.getSubjectById(subjectId);
}
@PostMapping("/create-Lesson")
    public ResponseDTO createLesson(@RequestBody LessonDTO lessonDTO){
        return resourceServices.createLesson(lessonDTO);
}
@GetMapping("/lessons")
    public ResponseDTO getLessons(){
        return resourceServices.getLessons();
}
@GetMapping("/get-Lesson/{lessonId}")
    public ResponseDTO getLessonsById(@PathVariable long lessonId){
        return resourceServices.getLessonById(lessonId);
}
@PostMapping("/create-Topic")
    public ResponseDTO createTopic(@RequestBody TopicDTO topicDTO){
        return resourceServices.createTopic(topicDTO);
}
@GetMapping("/topics")
    public ResponseDTO getTopics(){
        return resourceServices.getTopics();
}
@GetMapping("/get-Topic/{topicId}")
public ResponseDTO getTopicById(@PathVariable long topicId){
        return resourceServices.getTopicById(topicId);
}

@PostMapping("/create-Content")
    public ResponseDTO createContent(@RequestBody ContentDTO contentDTO){
        return resourceServices.createContent(contentDTO);
}
@GetMapping("/content")
    public ResponseDTO getContent(){
        return resourceServices.getContent();
}
@GetMapping("/get-Content/{contentId}")
    public ResponseDTO getContentById(@PathVariable long contentId){
        return resourceServices.getContentById(contentId);

}
@PutMapping("/content/{id}")
public  ResponseDTO updateContent(@PathVariable long id , @RequestBody ContentDTO contentDTO){
        return resourceServices.updateContent(id , contentDTO);
}


@PostMapping("/create-Content-Type")
    public ResponseDTO createContentType(@RequestBody ContentTypeDTO contentTypeDTO){
        return resourceServices.createContentType(contentTypeDTO);
}
@GetMapping("/content-Types")
    public ResponseDTO getContentTypes(){
        return resourceServices.getContentTypes();
}

@PostMapping("/create-HomeWork")
    public ResponseDTO createHomeWork(HomeWorkDTO homeWorkDTO){
        return resourceServices.createHomework(homeWorkDTO);
}
@GetMapping("/HomeWorks")
    public ResponseDTO getHomeWorks(){
        return resourceServices.getHomeWorks();
}

@PutMapping("/homeWork/{id}")
    public ResponseDTO updateHomeWork(@PathVariable long id, @RequestBody HomeWorkDTO homeWorkDTO){
        return resourceServices.updateHomeWork(id , homeWorkDTO);
}
@DeleteMapping ("/homeWork/{id}")
    public ResponseDTO delete(@PathVariable long id ){
        return resourceServices.deleteById(id);
}

    @PostMapping("/create-Question")
    public ResponseDTO createQuestion(@RequestBody QuestionDTO questionDTO){
        return resourceServices.createQuestion(questionDTO);
    }
    @GetMapping("/questions")
    public ResponseDTO getQuestions(){
        return resourceServices.getQuestions();
    }
    @GetMapping("/question/{id}")
    public ResponseDTO getSingleQuestion(@PathVariable long id){
        return resourceServices.getSingleQuestion(id);
    }
    @PutMapping("/question/{id}")
    public ResponseDTO updateQuestion(@PathVariable long id , @RequestBody QuestionDTO questionDTO){
        return resourceServices.updateQuestion(id , questionDTO);
    }
    @DeleteMapping("/question/{id}")
    public ResponseDTO deleteQuestion(@PathVariable long id){
        return resourceServices.deleteQuestion(id);
    }


}

