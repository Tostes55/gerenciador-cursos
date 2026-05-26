package com.gerenciador.cursos.service;

import com.gerenciador.cursos.dto.CourseDTO;
import com.gerenciador.cursos.entity.Course;
import com.gerenciador.cursos.mapper.CourseMapper;
import com.gerenciador.cursos.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course>findAll(){
        return courseRepository.findAll();
    }

    public List<Course> findByNameAndCategory(String name, String category){
        return courseRepository.findByNameAndCategory(name, category);
    }

    public Course CreateCourse(CourseDTO dto){

        Course course = CourseMapper.toEntity(dto);
        Course savedCourse = courseRepository.save(course);

        return this.courseRepository.save(savedCourse);

    }

    public Course updateCourse(CourseDTO dto, Long id){

        var existCourse = courseRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException ("Course not found with id " + id));

        if (dto.name() != null) {
            existCourse.setName(dto.name());
        }
        if (dto.category() != null) {
            existCourse.setCategory(dto.category());
        }

        return courseRepository.save(existCourse);

    }

    public void deleteCourse(Long id){
        courseRepository.deleteById(id);
    }

    public void disableCourse(Long id){
        Optional<Course> course = courseRepository.findById(id);
        course.ifPresent(c -> {
            c.setActive(false);
            courseRepository.save(c);
        });
    }

    public void enableCourse(Long id){
        Optional<Course> course = courseRepository.findById(id);
        course.ifPresent(c -> {
            c.setActive(true);
        });
    }



}
