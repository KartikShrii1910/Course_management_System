//package com.coursemanagement.controller;
//
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import com.coursemanagement.entities.CustomUserDetails;
//
//
//@Controller
//public class PurchaseRecordController {
//	@GetMapping("/check")
//	public String show(@AuthenticationPrincipal CustomUserDetails cs) {
//		String s = cs.getRole();
//		if (s.equals("ROLE_ADMIN")) {
//			return "redirect:/studentdetails";
//		} else if (s.equals("ROLE_NORMAL")) {
//			return "redirect:/coursesdetails";
//		}
//
//		return "redirect:/signin";
//	}
//
//}
