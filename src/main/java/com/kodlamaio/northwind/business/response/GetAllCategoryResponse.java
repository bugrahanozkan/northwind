package com.kodlamaio.northwind.business.response;

import java.util.List;

import com.kodlamaio.northwind.entities.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class GetAllCategoryResponse {
 private int id ;
 private String name;
 //private List<Product> products;
}
