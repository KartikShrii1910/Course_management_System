package com.coursemanagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coursemanagement.entities.Course;
import com.coursemanagement.response.Response;
import com.coursemanagement.services.CourseService;

@CrossOrigin(origins = "*")
@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	@GetMapping("/coursesdetails")
	public ResponseEntity<List<Course>> listBankDetail() {
		List<Course> coursesDetails = courseService.getAllCoursesDetails();
		return ResponseEntity.ok().body(coursesDetails);
	}

	@PostMapping("/course/new")
	public ResponseEntity<Response> saveCoursesDetails(@RequestBody Course coursesDetails) {
		Response response = new Response();

		response.setCode("200");
		response.setMessage("OK");
		response.setObject(coursesDetails);
		courseService.saveStudentDetail(coursesDetails);

		return ResponseEntity.ok().body(response);
	}
}
