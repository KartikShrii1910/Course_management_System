package com.coursemanagement.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coursemanagement.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	Student findByEmail(String email);
	
	@Query(value = "SELECT s.id AS student_id, " +
	        "s.full_name AS student_name, " +
	        "s.email AS student_email, " +
	        "s.qualification AS student_qualification, " +
	        "s.mobile_number AS student_number, " +
	        "s.gender AS student_gender, " +
	        "c.course_name, " +
	        "c.course_description, " +
	        "c.duration AS course_duration, " +
	        "pr.id AS purchase_id, " +
	        "c.id AS course_id " +
	        "FROM student s " +
	        "JOIN purchase_record pr ON s.id = pr.student_id " +
	        "JOIN course c ON c.id = pr.course_id", nativeQuery = true)
	List<Map<String, Object>> getResultList();
	
	
	boolean existsByEmail(String email);
}
