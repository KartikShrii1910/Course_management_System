package com.coursemanagement.servicesImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coursemanagement.entities.PurchaseRecord;
import com.coursemanagement.repositories.PurchaseRecordRepository;
import com.coursemanagement.services.purchaseRecordService;

@Service
public class PurchaseRecordServiceImpl implements purchaseRecordService{
	
	@Autowired
	private PurchaseRecordRepository purchaseRecordRepository;

	@Override
	public PurchaseRecord registerUserWithCourse(PurchaseRecord userCourseRequest) {
		// TODO Auto-generated method stub
		return purchaseRecordRepository.save(userCourseRequest);
	}

	@Override
	public List<Map<String, Object>> findPurchasedCoursesByStudentId(int id) {
		// TODO Auto-generated method stub
		return purchaseRecordRepository.findPurchasedCoursesByStudentId(id);
	}

}
