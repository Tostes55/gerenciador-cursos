package com.gerenciador.cursos.mapper;

import com.gerenciador.cursos.dto.CourseDTO;
import com.gerenciador.cursos.entity.Course;

public class CourseMapper {

    public static Course toEntity (CourseDTO dto) {

        if (dto == null) { return null;}

        Course course = new Course();
        course.setName(dto.name());
        course.setCategory(dto.category());

        return course;

    }

    public static CourseDTO toDTO (Course entity) {
        if (entity == null) { return null;}

        return new CourseDTO(
                entity.getName(),
                entity.getCategory());

    }
}
