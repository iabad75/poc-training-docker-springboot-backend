package io.oferto.poctrainingdockernodejsbackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Product")
public class Product {
	@Id
    private String id;
	
	@NonNull
	private String name;
	
	private String description;
	
	@NonNull
	private float price;
	
	@NonNull
	private boolean active;
}
