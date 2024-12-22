package com.coursemanagement.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import com.coursemanagement.entities.Student;
import com.coursemanagement.services.CustomUserDetailService;
import com.coursemanagement.services.StudentService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenProvider {
	
	@Autowired
	private StudentService studentService;

	@Autowired
	private CustomUserDetailService customUserDetailService;

	@Value("${app.jwtSecret}")
	private String jwtSecret;

	@Value("${app.jwtExpirationInMs}")
	private int jwtExpirationInMs;

	public String generateToken(Authentication authentication,String username) {
//		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		
		Student student = studentService.findByEmail(username);
		
//		Student student = new Student();
		  Map<String, Object> claims = new HashMap<>();
		    claims.put("fullName", student.getFullName());
		    claims.put("role", student.getRole());
		    claims.put("gender", student.getGender());
		    claims.put("email", student.getEmail());
		    claims.put("qualification", student.getQualification());
		    claims.put("address", student.getAddress());
		    claims.put("mobileNumber", student.getMobileNumber());
		    claims.put("dateOfBirth", student.getDateOfBirth());

		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);
		SecretKey key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
		
		return Jwts.builder().setSubject(claims.toString()).setIssuedAt(new Date()).setExpiration(expiryDate)
				.signWith(key, SignatureAlgorithm.HS512).compact();
	}

	public String getUsernameFromJWT(String token) {

		Claims claims = Jwts.parser().setSigningKey(jwtSecret.getBytes()).parseClaimsJws(token).getBody();
		System.out.println(token);

		return claims.getSubject();
	}

	public Authentication validateToken(String authToken) {
		try {

			// Extract user details from the token claims
			String username = getUsernameFromJWT(authToken);
			UserDetails userDetails = customUserDetailService.loadUserByUsername(username);

			// Create authentication object with user details
			return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
		} catch (SignatureException ex) {
			// Invalid signature
			throw new IllegalArgumentException("Invalid JWT signature");
		} catch (MalformedJwtException ex) {
			// Malformed token
			throw new IllegalArgumentException("Malformed JWT token");
		} catch (ExpiredJwtException ex) {
			// Expired token
			throw new IllegalArgumentException("Expired JWT token");
		} catch (Exception ex) {
			// Other exceptions
			throw new IllegalArgumentException("Invalid JWT token");
		}
	}
}