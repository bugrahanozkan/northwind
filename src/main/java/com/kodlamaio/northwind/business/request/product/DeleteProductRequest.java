package com.kodlamaio.northwind.business.request.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteProductRequest {
	private int categoryId;
	private String name;
	
	private double unitPrice;
	
	private int unitInStock;
}
