//package com.coursemanagement.controller;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.coursemanagement.entities.PhotoUpload;
//import com.coursemanagement.servicesImpl.PhotoUploadServiceImpl;
//
//@RestController
//public class PhotoUploadController {
//	
//	@Autowired
//	private PhotoUploadServiceImpl photoUploadServiceImpl;
//
//	private static final String UPLOAD_DIR = "D:/uploads/";
//	// upload pdf file in pc folder
//		// =======================================================================
//		@PostMapping("/upload")
//		public String uploadPdf(@RequestParam("file") MultipartFile file , @RequestParam("item_code") String itemCode,@RequestParam("center_code") String centerCode ) throws IOException {
//
//			// System.out.println("/upload 86 in persondetails controller");
//			if (!file.isEmpty()) {
//
//				// Generate a unique file name using UUID
//				String fileName = file.getOriginalFilename();
//				 
//				// Save the file to the specified directory
//				saveFile(file, fileName);
//				PhotoUpload file1 = new PhotoUpload();
//
//				file1.setImageName(fileName);
//				file1.setPath(UPLOAD_DIR + file.getOriginalFilename());
//				file1.setCenter_code(centerCode);
//				file1.setItem_code(itemCode);
//				 
//
//				 
//
//				photoUploadServiceImpl.saveFile(file1);
//
//				return "File uploaded successfully!";
//			} else {
//				return "Failed to upload file. File is empty.";
//			}
//
//		}
//
//		private void saveFile(MultipartFile file, String fileName) throws IOException {
//			// Create the upload directory if it doesn't exist
//			File uploadDir = new File(UPLOAD_DIR);
//			if (!uploadDir.exists()) {
//				uploadDir.mkdirs();
//			}
//
//			// Save the file to the upload directory
//			File destFile = new File(uploadDir, fileName);
//			try (FileOutputStream outputStream = new FileOutputStream(destFile)) {
//				outputStream.write(file.getBytes());
//			}
//		}
//}
