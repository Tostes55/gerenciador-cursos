package com.gerenciador.cursos.controller;

import com.gerenciador.cursos.dto.CourseDTO;
import com.gerenciador.cursos.entity.Course;
import com.gerenciador.cursos.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/all")
    public List<Course> findAll() {
        return this.courseService.findAll();
    }

    @GetMapping("/")
    public List<Course> findByNameAndCategory(@RequestParam String name,
                                              @RequestParam String category){
        return this.courseService.findByNameAndCategory(name, category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCourses(@PathVariable Long id,
                                                @RequestBody CourseDTO courseDTO) {
        this.courseService.updateCourse(courseDTO, id);

        return ResponseEntity.ok().body(courseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCourse(@PathVariable Long id) {
        this.courseService.deleteCourse(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PatchMapping("/{id}/active")
    public ResponseEntity<Object> activeCourse(@PathVariable Long id) {
        this.courseService.enableCourse(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PatchMapping("/{id}/inactive")
    public ResponseEntity<Object> inactiveCourse(@PathVariable Long id) {
        this.courseService.disableCourse(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
