package com.coursemanagement.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PhotoUpload {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sNo;
	
	private String item_code;
	
	private String path;
	
	private String center_code;
	
	private String imageName;

	public PhotoUpload(String item_code, String path, String center_code, String imageName) {
		super();
		this.item_code = item_code;
		this.path = path;
		this.center_code = center_code;
		this.imageName = imageName;
	}

	public PhotoUpload() {
		super();
	}

	public int getsNo() {
		return sNo;
	}

	public void setsNo(int sNo) {
		this.sNo = sNo;
	}

	public String getItem_code() {
		return item_code;
	}

	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getCenter_code() {
		return center_code;
	}

	public void setCenter_code(String center_code) {
		this.center_code = center_code;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
}
