package com.coursemanagement.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String courseName;

	private String courseDescription;

	private String duration;

	private int fees;

	private Date startDate;

	private Date endDate;

	private double rating;

	public Course() {
		super();
	}

	public Course(String courseName, String courseDescription, String duration, int fees, Date startDate, Date endDate,
			double rating) {
		super();
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.duration = duration;
		this.fees = fees;
		this.startDate = startDate;
		this.endDate = endDate;
		this.rating = rating;
	}

	public Course(int id, String courseName, String courseDescription, String duration, int fees, Date startDate,
			Date endDate, double rating) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.duration = duration;
		this.fees = fees;
		this.startDate = startDate;
		this.endDate = endDate;
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", courseDescription=" + courseDescription
				+ ", duration=" + duration + ", fees=" + fees + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", rating=" + rating + "]";
	}

}
