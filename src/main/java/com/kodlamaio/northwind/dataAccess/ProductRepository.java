package com.kodlamaio.northwind.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.northwind.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
   Product findByName(String name);
}
