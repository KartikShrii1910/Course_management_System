package com.coursemanagement.services;

import java.util.List;

import com.coursemanagement.entities.Course;

public interface CourseService {

	Course saveStudentDetail(Course coursesDetails);

	List<Course> getAllCoursesDetails();

}
