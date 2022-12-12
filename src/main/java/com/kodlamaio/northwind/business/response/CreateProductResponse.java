package com.kodlamaio.northwind.business.response;

import com.kodlamaio.northwind.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateProductResponse {//veritabanına eklenen productun doğru eklenip eklenmediğini görmemizi sağlar.
	 
	private int id;
	
	private int categoryId;
	
	private String name;
	
	private double unitPrice;
	
	private int unitInStock;
	
}
