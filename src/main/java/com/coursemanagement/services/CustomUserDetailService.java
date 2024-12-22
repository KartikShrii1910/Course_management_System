package com.coursemanagement.services;

import org.springframework.security.core.userdetails.UserDetails;

public interface CustomUserDetailService  {

	public UserDetails loadUserByUsername(String email) ;

}
