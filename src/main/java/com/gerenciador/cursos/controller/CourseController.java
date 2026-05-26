package com.gerenciador.cursos.controller;

import com.gerenciador.cursos.dto.CourseDTO;
import com.gerenciador.cursos.entity.Course;
import com.gerenciador.cursos.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/")
    public ResponseEntity<Object> createCourse(@RequestBody CourseDTO courseDTO) {

        try{
            this.courseService.CreateCourse(courseDTO);
        }catch (Exception e){
            e.printStackTrace();
        }

        return ResponseEntity.ok().body(courseDTO);

    }

    @GetMapping("/")
    public List<Course> findAll() {
        return this.courseService.findAll();
    }

}
