package io.oferto.poctrainingdockernodejsbackend.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.oferto.poctrainingdockernodejsbackend.dto.ProductDto;
import io.oferto.poctrainingdockernodejsbackend.error.ResourceNotFoundException;
import io.oferto.poctrainingdockernodejsbackend.model.Product;
import io.oferto.poctrainingdockernodejsbackend.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		LOGGER.info("find all products");
        
		List<Product> products = (List<Product>) productRepository.findAll();
		return ResponseEntity.ok(products);
	}
	 
	@GetMapping("/{id}")
	public ResponseEntity<Product> findById(@PathVariable String id) 
			throws ResourceNotFoundException {
		LOGGER.info("find product by id: {}", id);
		
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id: " + id));
		
		return ResponseEntity.ok(product);
	}
	
	@PostMapping
	public Product save(@Valid @RequestBody Product product) {
		LOGGER.info("find all products");
		
		return productRepository.save(product);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> update(@PathVariable String id, @Valid @RequestBody ProductDto productDto) 
			throws ResourceNotFoundException {
		LOGGER.info("update product by id: ", id);
		
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id: " + id));
	            
		product.setName(productDto.getName());
		product.setDescription(productDto.getDescription());
		product.setPrice(productDto.getPrice());
		product.setActive(productDto.isActive());
		
        final Product productUpdated = productRepository.save(product);
        
        return ResponseEntity.ok(productUpdated);
	}
	
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") String id) 
    		throws ResourceNotFoundException {
    	LOGGER.info("delete product by id: ", id);
    	
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id: " + id));

		productRepository.delete(product);
    }
}
