package com.coursemanagement.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String fullName;

	private String gender;

	private Date dateOfBirth;

	private String email;

	private String password;

	private String qualification;

	private String role;

	private String address;

	private long mobileNumber;

	private int flag;

	public Student() {
		super();
	}

	public Student(int id, String fullName, String gender, Date dateOfBirth, String email, String password,
			String qualification, String role, String address, long mobileNumber, int flag) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;

		this.email = email;
		this.password = password;
		this.qualification = qualification;
		this.role = role;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.flag = flag;
	}

	public Student(String fullName, String gender, Date dateOfBirth, String email, String password,
			String qualification, String role, String address, long mobileNumber, int flag) {
		super();
		this.fullName = fullName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;

		this.email = email;
		this.password = password;
		this.qualification = qualification;
		this.role = role;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.flag = flag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", fullName=" + fullName + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth
			  + ", email=" + email + ", password=" + password + ", qualification=" + qualification
				+ ", role=" + role + ", address=" + address + ", mobileNumber=" + mobileNumber + ", flag=" + flag + "]";
	}

}
