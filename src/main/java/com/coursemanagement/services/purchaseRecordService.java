package com.coursemanagement.services;

import java.util.List;
import java.util.Map;

import com.coursemanagement.entities.PurchaseRecord;

public interface purchaseRecordService {

	PurchaseRecord registerUserWithCourse(PurchaseRecord userCourseRequest);

	List<Map<String, Object>> findPurchasedCoursesByStudentId(int id);

}
