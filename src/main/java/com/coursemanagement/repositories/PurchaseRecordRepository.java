package com.coursemanagement.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coursemanagement.entities.PurchaseRecord;

@Repository
public interface PurchaseRecordRepository extends JpaRepository<PurchaseRecord, Integer>{

	@Query(value ="SELECT s.id AS student_id, s.full_name as student_name, " +
            "s.email as student_email, s.qualification as student_qualification, " +
            "s.mobile_number as student_number, s.gender as student_gender, " +
            "c.course_name, c.course_description, c.duration, " +
            "pr.id AS purchase_id, c.id AS course_id " +
            "FROM student s " +
            "JOIN purchase_record pr ON s.id = pr.student_id " +
            "JOIN course c ON c.id = pr.course_id " +
            "WHERE s.id = ?", nativeQuery = true)
	List<Map<String, Object>> findPurchasedCoursesByStudentId(int id);
	

}
