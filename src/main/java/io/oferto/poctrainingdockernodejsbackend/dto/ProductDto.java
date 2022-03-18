package io.oferto.poctrainingdockernodejsbackend.dto;

import com.mongodb.lang.NonNull;

import lombok.Data;

@Data
public class ProductDto {
	
	@NonNull
	private String name;
	
	private String description;
	
	@NonNull
	private float price;
	
	@NonNull
	private boolean active;
}
