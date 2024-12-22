package com.coursemanagement.servicesImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coursemanagement.entities.Student;
import com.coursemanagement.repositories.StudentRepository;
import com.coursemanagement.services.StudentService;

@Service
public class StundetServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

//	private EntityManager entityManager;

	@Override
	public List<Student> getAllStudentsDetail() {

		return studentRepository.findAll();
	}

	@Override
	public Student saveStudentDetail(Student studentDetails) {
		if (studentRepository.existsByEmail(studentDetails.getEmail())) {
			studentDetails.setFlag(1);
			throw new RuntimeException("Email already exists!");
		}
		return studentRepository.save(studentDetails);
	}

	@Override
	public Student getStudentDetailById(int id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id).get();
	}

	@Override
	public Student updateStudentsDetail(Student existingStudentDetail) {
		// TODO Auto-generated method stub
		return studentRepository.save(existingStudentDetail);

	}

	@Override
	public Student findByEmail(String username) {
		// TODO Auto-generated method stub
		return studentRepository.findByEmail(username);
	}

	@Override
	public List<Map<String, Object>> getAllDetail() {
		 
		return studentRepository.getResultList();

//		return studentRepository.getAlldetails();
	}

}
