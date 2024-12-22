package com.coursemanagement.services;

import org.springframework.web.multipart.MultipartFile;



public interface PhotoUploadService {

	void savePhoto(MultipartFile file, String centerCode, String itemCode, String path) throws java.io.IOException;

	 

}
