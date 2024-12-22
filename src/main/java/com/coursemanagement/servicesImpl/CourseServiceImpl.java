package com.coursemanagement.servicesImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coursemanagement.entities.Course;
import com.coursemanagement.repositories.CourseRepositptory;
import com.coursemanagement.services.CourseService;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseRepositptory courseRepositptory;

	@Override
	public Course saveStudentDetail(Course coursesDetails) {
		// TODO Auto-generated method stub
		return courseRepositptory.save(coursesDetails);
	}

	@Override
	public List<Course> getAllCoursesDetails() {
		// TODO Auto-generated method stub
		return courseRepositptory.findAll();
	}

}
