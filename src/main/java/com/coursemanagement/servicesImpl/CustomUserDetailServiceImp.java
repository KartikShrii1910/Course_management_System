package com.coursemanagement.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.coursemanagement.entities.CustomUserDetails;
import com.coursemanagement.entities.Student;
import com.coursemanagement.repositories.StudentRepository;
import com.coursemanagement.services.CustomUserDetailService;

 


@Service
public class CustomUserDetailServiceImp implements  CustomUserDetailService , UserDetailsService{

	@Autowired
	private StudentRepository studentRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Student user = this.studentRepository.findByEmail(email);
		if (user==null) {
			throw new UsernameNotFoundException("No User");
		}
		
		return new CustomUserDetails(user);
	}
	
}
