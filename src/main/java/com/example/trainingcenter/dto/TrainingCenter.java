package com.example.trainingcenter.dto;

import java.util.List;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
/*
 * Entity Class to create a table in the database
 */
@Entity
@Data
public class TrainingCenter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Size(max = 50, message = "Enter the Center Name less than 50 characters")
	@NotBlank(message = "Center Name cannot be empty")
	private String centerName;
	@NotBlank(message = "Center Code cannot be empty")
	@Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "Center code must be exactly 12 alphanumeric characters")
	private String centerCode;
	@Valid
	@Embedded
	private Address address;
	private int capacity;
	private List<String> coursesOffered;
	private long createdOn;
	@Email
	private String contactEmail;
	@DecimalMin(value = "6000000000", message = "Enter Proper Mobile No")
	@DecimalMax(value = "9999999999", message = "Enter Proper Mobile No")
	@NotBlank(message = "Phone No cannot be Empty")
	private String contactPhone;
}
