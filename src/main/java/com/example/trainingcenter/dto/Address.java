package com.example.trainingcenter.dto;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Embeddable
@Data
public class Address {
	@NotBlank(message = "Address cannot be Empty")
	String detailedAddress;
	@NotBlank(message = "Enter City Name")
	String city;
	@NotBlank(message = "Enter State Name")
	String state;
	@NotBlank(message = "Enter Pincode")
	@Pattern(regexp = "^[1-9][0-9]{5}$", message = "Invalid pincode")
	String pincode;
}
