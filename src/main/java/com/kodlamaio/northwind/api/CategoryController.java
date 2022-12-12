package com.kodlamaio.northwind.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.northwind.business.abstracts.CategoryService;
import com.kodlamaio.northwind.business.request.category.CreateCategoryRequest;
import com.kodlamaio.northwind.business.response.CreateCategoryResponse;
import com.kodlamaio.northwind.business.response.GetAllCategoryResponse;
import com.kodlamaio.northwind.business.response.GetCategoryResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/categories/")
@AllArgsConstructor
public class CategoryController {
	private CategoryService categoryService;

	@GetMapping("getAll")
	public List<GetAllCategoryResponse> getAll() {
		return categoryService.getAll();
	}

	@PostMapping("add")
	public CreateCategoryResponse add(@RequestBody CreateCategoryRequest createCategoryResponse) {
		return categoryService.add(createCategoryResponse);
	}

	@GetMapping("getByName")
	public GetAllCategoryResponse getByName(@RequestParam String name) {
		return categoryService.getByName(name);
	}

	@GetMapping("getById/{id}")
	public GetCategoryResponse getById(@PathVariable int id) {
		return categoryService.getById(id);
	}
	
	@DeleteMapping("deleteCategoryById/{id}")
	 void deleteCategoryById (@PathVariable  int id) {
		 categoryService.deleteCategoryById(id);
	 }
	@PutMapping("uptadeCategorById")
	 CreateCategoryResponse uptadeCategorById(@RequestBody CreateCategoryRequest request) {
		 return categoryService.uptadeCategorById(request);
	 }
	
	
	
}
