package io.oferto.poctrainingdockernodejsbackend.repository;

import org.springframework.data.repository.CrudRepository;

import io.oferto.poctrainingdockernodejsbackend.model.Product;

public interface ProductRepository extends CrudRepository<Product, String> {

}
