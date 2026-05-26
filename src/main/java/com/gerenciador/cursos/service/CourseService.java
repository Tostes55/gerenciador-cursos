package com.gerenciador.cursos.service;

import com.gerenciador.cursos.dto.CourseDTO;
import com.gerenciador.cursos.entity.Course;
import com.gerenciador.cursos.mapper.CourseMapper;
import com.gerenciador.cursos.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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



}
