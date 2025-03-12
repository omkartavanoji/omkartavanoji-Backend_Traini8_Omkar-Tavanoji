package com.example.trainingcenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.trainingcenter.dto.TrainingCenter;
import com.example.trainingcenter.service.TrainingCenterService;

import jakarta.validation.Valid;
/*
 * Controller layer for Mapping logic
 */
@RestController
@RequestMapping("/training")
public class TrainingCenterController {
	@Autowired
	TrainingCenterService trainingCenterService;
	
/*
 * api to  create and save a new training center
 */
	@PostMapping("/add-center")
	public ResponseEntity<String> addTraining(@Valid @RequestBody TrainingCenter center) {
		return trainingCenterService.addTraining(center);
	}

	/*
	 * api to get list of all stored training centers information.
	 */
	@GetMapping("/get-center")
	public ResponseEntity<List<TrainingCenter>>getTrainingCenter() {
		return trainingCenterService.getTrainingCenter();
	}
	
	/*
	 * api to filter data in the list api 
	 */
	@GetMapping("/search")
	public ResponseEntity<Object> searchCenter(@RequestParam String search){
		return trainingCenterService.searchCenter(search);
	}
}
