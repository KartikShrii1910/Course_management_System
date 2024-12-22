package com.coursemanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coursemanagement.entities.PhotoUpload;

public interface PhotoUploadRepository extends JpaRepository<PhotoUpload, Integer> {

}
