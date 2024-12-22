package com.coursemanagement.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.coursemanagement.config.JwtTokenProvider;
import com.coursemanagement.entities.PurchaseRecord;
import com.coursemanagement.entities.Student;
import com.coursemanagement.response.JwtAuthenticationResponse;
import com.coursemanagement.response.Response;
import com.coursemanagement.services.StudentService;
import com.coursemanagement.services.purchaseRecordService;

@CrossOrigin(origins = "*")
@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private purchaseRecordService purchaseRecordService;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody Student loginRequest) {
		System.out.println(loginRequest.getEmail());
		System.out.println(loginRequest.getPassword());
		
		String username =loginRequest.getEmail();
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		System.err.println(SecurityContextHolder.getContext().getAuthentication());
		String jwt = jwtTokenProvider.generateToken(authentication,username);
		System.out.println(new JwtAuthenticationResponse(jwt).getAccessToken());
		return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
	}

//	@GetMapping("/login/userdetails")
//	public ResponseEntity<Student> getUserDetails(@RequestHeader("Authorization") String authToken) {
//		System.out.println("entered in api");
//		// Get authentication object from SecurityContextHolder
//		System.err.println(authToken);
//
//		Authentication authentication = jwtTokenProvider.validateToken(authToken);
//
//		String username = authentication.getName();
//
//		Student user = studentService.findByEmail(username);
//
//		// Check if user exists
//		if (user != null) {
//			// Return user details with a 200 OK status code
//			return ResponseEntity.ok(user);
//		} else {
//			// Return 404 Not Found if user is not found
//			return ResponseEntity.notFound().build();
//		}
//	}

	@GetMapping("/studentdetails")
	public ResponseEntity<List<Student>> listStudentDetail() {
		List<Student> studentDetails = studentService.getAllStudentsDetail();
		return ResponseEntity.ok().body(studentDetails);
	}

	@PostMapping("/studentdetails/new")
	public ResponseEntity<Response> saveStudnetsDetail(@RequestBody Student studentDetails) {
		Response response = new Response();

		studentDetails.setPassword(this.bCryptPasswordEncoder.encode(studentDetails.getPassword()));

		response.setCode("200");
		response.setMessage("OK");
		response.setObject(studentDetails);
		studentService.saveStudentDetail(studentDetails);

		return ResponseEntity.ok().body(response);
	}

	@PutMapping("/studentsdetails/edit/{id}")
	public ResponseEntity<Response> updateStudentDetail(@PathVariable int id,
			@RequestBody Student updatedStudentDetail) {
		Response response = new Response();

		// Check if the new accountNumber is already associated with another record

		// Account number is unique or belongs to the current record being updated
		response.setCode("200");
		response.setMessage("OK");

		// Get the existing bank detail by ID
		Student existingStudentDetail = studentService.getStudentDetailById(id);

		// Update the fields with new values
		existingStudentDetail.setFullName(updatedStudentDetail.getFullName());
		existingStudentDetail.setAddress(updatedStudentDetail.getAddress());
		existingStudentDetail.setMobileNumber(updatedStudentDetail.getMobileNumber());
//		existingStudentDetail.setAge(updatedStudentDetail.getAge());
		existingStudentDetail.setDateOfBirth(updatedStudentDetail.getDateOfBirth());
		existingStudentDetail.setEmail(updatedStudentDetail.getEmail());
		existingStudentDetail.setGender(updatedStudentDetail.getGender());
		existingStudentDetail.setQualification(updatedStudentDetail.getQualification());
		existingStudentDetail.setPassword(updatedStudentDetail.getPassword());
		existingStudentDetail.setRole(updatedStudentDetail.getRole());

		// Save the updated bank detail
		studentService.updateStudentsDetail(existingStudentDetail);

		// Set the updated bank detail in the response
		response.setObject(existingStudentDetail);

		return ResponseEntity.ok().body(response);
	}

	@PostMapping("/coursepurchase")
	public ResponseEntity<PurchaseRecord> registerUserWithCourse(@RequestBody PurchaseRecord userCourseRequest) {
		PurchaseRecord purchasRecord = purchaseRecordService.registerUserWithCourse(userCourseRequest);
//		System.out.println("user id ========" + user.getCourse_id());
//		System.out.println("studentid id ========" + user.getStudent_id());

		return ResponseEntity.ok(purchasRecord);
	}

	@GetMapping("/coursepurchase/{id}")
	public ResponseEntity<List<Map<String, Object>>> getPurchasedCoursesByStudentId(@PathVariable int id) {
		List<Map<String, Object>> purchasedCourses = purchaseRecordService.findPurchasedCoursesByStudentId(id);
		return ResponseEntity.ok(purchasedCourses);
	}

	@GetMapping("/allpurchasecourses")
	public ResponseEntity<List<Map<String, Object>>> allDetail() {
		List<Map<String, Object>> studentDetails = studentService.getAllDetail();
		return ResponseEntity.ok().body(studentDetails);
	}

}
