package com.gerenciador.cursos.repository;

import com.gerenciador.cursos.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findAll();

    List <Course> findByNameAndCategory(String name, String category);



}
