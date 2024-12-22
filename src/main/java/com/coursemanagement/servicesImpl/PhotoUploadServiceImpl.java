package com.coursemanagement.servicesImpl;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coursemanagement.entities.PhotoUpload;
import com.coursemanagement.repositories.PhotoUploadRepository;

@Service
public class PhotoUploadServiceImpl  {

	@Autowired
	private PhotoUploadRepository photoUploadRepository;
	
	 
	public void saveFile(PhotoUpload file1) {
		 
		photoUploadRepository.save(file1);
	}
}