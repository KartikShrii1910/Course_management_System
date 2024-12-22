package com.coursemanagement.services;

import java.util.List;
import java.util.Map;

import com.coursemanagement.entities.Student;

public interface StudentService {

	List<Student> getAllStudentsDetail();

	Student saveStudentDetail(Student studentDetails);

	Student getStudentDetailById(int id);

	Student updateStudentsDetail(Student existingStudentDetail);

	Student findByEmail(String username);

	List<Map<String, Object>> getAllDetail();

	 

}
