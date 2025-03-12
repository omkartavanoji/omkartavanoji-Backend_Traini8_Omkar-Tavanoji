package com.example.trainingcenter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.trainingcenter.dto.TrainingCenter;
/*
 *  Repository layer to interact with database
 */
@Repository
public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Integer> {
	boolean existsBycontactEmail(String contactEmail);

	List<TrainingCenter> findBycenterNameLike(String searchString);

	List<TrainingCenter> findByAddress_StateLike(String searchString);

	List<TrainingCenter> findByAddress_CityLike(String searchString);
	
}
