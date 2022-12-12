package com.kodlamaio.northwind.business.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductsResponse {
 private int id ;
 private String name ;
 private String categoryName;
 private int unInStock;
 private double unitPrice;
 
}
