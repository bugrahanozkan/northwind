package com.kodlamaio.northwind.business.request.category;

import java.util.List;

import com.kodlamaio.northwind.entities.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryRequest {
	private int id;
	private String name;
	// private List<Product> products;
}
