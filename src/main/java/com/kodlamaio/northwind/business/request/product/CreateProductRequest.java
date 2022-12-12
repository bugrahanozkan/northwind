package com.kodlamaio.northwind.business.request.product;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.kodlamaio.northwind.entities.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {

	
	private int categoryId;
	private String name;
	
	private double unitPrice;
	
	private int unitInStock;
	
	
	
}
