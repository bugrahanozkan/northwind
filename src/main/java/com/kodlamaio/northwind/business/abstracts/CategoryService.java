package com.kodlamaio.northwind.business.abstracts;

import java.util.List;

import com.kodlamaio.northwind.business.request.category.CreateCategoryRequest;
import com.kodlamaio.northwind.business.request.product.UpdateProductRequest;
import com.kodlamaio.northwind.business.response.CreateCategoryResponse;
import com.kodlamaio.northwind.business.response.GetAllCategoryResponse;
import com.kodlamaio.northwind.business.response.GetCategoryResponse;
import com.kodlamaio.northwind.business.response.ProductUpdateResponse;
import com.kodlamaio.northwind.entities.Category;

public interface CategoryService {
 List<GetAllCategoryResponse> getAll();
 
 CreateCategoryResponse add(CreateCategoryRequest createCategoryRequest);
 
 GetAllCategoryResponse getByName(String name);
 
 GetCategoryResponse getById(int id);
 
 
 void deleteCategoryById (int id);

 
 CreateCategoryResponse uptadeCategorById(CreateCategoryRequest request);

}
