package com.example.trainingcenter.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.trainingcenter.dto.TrainingCenter;
import com.example.trainingcenter.repository.TrainingCenterRepository;
/*
 * Service Layer to write Logic
 */
@Service
public class TrainingCenterService {
	@Autowired
	TrainingCenterRepository repository;

	public ResponseEntity<String> addTraining(TrainingCenter center) {
		if (repository.existsBycontactEmail(center.getContactEmail())) {
			return new ResponseEntity<String>("DUPLICATE ENTRY FOUND", HttpStatus.CONFLICT);
		}
		center.setCreatedOn(Instant.now().getEpochSecond());
		repository.save(center);
		return new ResponseEntity<String>("ENTRY ENTERED SUCCESSFULLY", HttpStatus.CREATED);
	}

	public ResponseEntity<List<TrainingCenter>> getTrainingCenter() {
		List<TrainingCenter> list = repository.findAll();
		if (list.isEmpty()) {
			return new ResponseEntity<List<TrainingCenter>>(new ArrayList<TrainingCenter>(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<TrainingCenter>>(list, HttpStatus.FOUND);
	}

	public ResponseEntity<Object> searchCenter(String search) {
		String searchString = "%" + search + "%";
		List<TrainingCenter> list1 = repository.findBycenterNameLike(searchString);
		List<TrainingCenter> list2 = repository.findByAddress_StateLike(searchString);
		List<TrainingCenter> list3 = repository.findByAddress_CityLike(searchString);
		List<TrainingCenter>list = new ArrayList<TrainingCenter>();
		list.addAll(list1);
		list.addAll(list2);
		list.addAll(list3);
		if (list.isEmpty()) {
			return new ResponseEntity<Object>("NO TRAINING CENTER FOUND", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(list, HttpStatus.FOUND);
	}

}
