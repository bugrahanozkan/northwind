package com.kodlamaio.northwind.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlamaio.northwind.business.abstracts.CategoryService;
import com.kodlamaio.northwind.business.request.category.CreateCategoryRequest;
import com.kodlamaio.northwind.business.response.CreateCategoryResponse;
import com.kodlamaio.northwind.business.response.GetAllCategoryResponse;
import com.kodlamaio.northwind.business.response.GetCategoryResponse;
import com.kodlamaio.northwind.business.response.ProductUpdateResponse;
import com.kodlamaio.northwind.dataAccess.CategoryRepository;
import com.kodlamaio.northwind.entities.Category;
import com.kodlamaio.northwind.entities.Product;


@Service
public class CategoryManager implements CategoryService {
	private CategoryRepository categoryRepository;

	public CategoryManager(CategoryRepository categoryRepository) {

		this.categoryRepository = categoryRepository;
	}

	@Override
	public GetCategoryResponse getById(int id) {
		 Category category = categoryRepository.findById(id).orElse(null);
		 GetCategoryResponse response= new GetCategoryResponse();
		 response.setName(category.getName());
		 response.setId(category.getId());
		return response;
	}

	@Override
	public List<GetAllCategoryResponse> getAll() {
	List <GetAllCategoryResponse> responseList = new ArrayList<>();
	
	for (Category category : categoryRepository.findAll()) {
		GetAllCategoryResponse response = new GetAllCategoryResponse();
		response.setId(category.getId());
		response.setName(category.getName());
		//response.setProducts(category.getProducts());
		responseList.add(response);
	}
		return responseList;
	}
	
	

	@Override
	public CreateCategoryResponse add(CreateCategoryRequest createCategoryResponse) {
		
		Category category = new Category();
		category.setName(createCategoryResponse.getName());
		
		categoryRepository.save(category);
		
		CreateCategoryResponse response= new CreateCategoryResponse();
		response.setId(category.getId());
		response.setName(category.getName());
		//response.setProductList(category.getProducts());
		return response;
	}

	@Override
	public GetAllCategoryResponse getByName(String name) {
		Category category = categoryRepository.findByName(name);
		GetAllCategoryResponse response = new GetAllCategoryResponse();
	    response.setId(category.getId());
	    response.setName(category.getName());
	   // response.setProducts(category.getProducts());
	    
		return response;
	}

	@Override
	public void deleteCategoryById(int id) {
		categoryRepository.deleteById(id);
		
	}

	@Override
	public CreateCategoryResponse uptadeCategorById(CreateCategoryRequest request) {
	//aşağıdaki iki satırın kısa yolu.
		Category category = categoryRepository.findById(request.getId()).get();
//		Category category = new Category();
//		category = categoryRepository.findById(request.getId()).get();
		
		category.setName(request.getName());
		//category.setProducts(request.getProducts());
		
		categoryRepository.save(category);
		
		CreateCategoryResponse categoryUpdateResponse = new CreateCategoryResponse();
		
		categoryUpdateResponse.setId(category.getId());
		categoryUpdateResponse.setName(category.getName());
		//categoryUpdateResponse.setProductList(category.getProducts());
		
		return categoryUpdateResponse;
	}

}
