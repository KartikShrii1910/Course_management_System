package com.coursemanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coursemanagement.entities.Course;

@Repository
public interface CourseRepositptory extends JpaRepository<Course, Integer>{

}
