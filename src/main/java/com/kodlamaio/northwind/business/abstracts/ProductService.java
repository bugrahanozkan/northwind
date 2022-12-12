package com.kodlamaio.northwind.business.abstracts;

import java.util.List;

import com.kodlamaio.northwind.business.request.product.CreateProductRequest;
import com.kodlamaio.northwind.business.request.product.UpdateProductRequest;
import com.kodlamaio.northwind.business.response.CreateProductResponse;
import com.kodlamaio.northwind.business.response.GetAllProductsResponse;
import com.kodlamaio.northwind.business.response.GetProductResponse;
import com.kodlamaio.northwind.business.response.OrderUpdateResponse;
import com.kodlamaio.northwind.business.response.ProductUpdateResponse;
//interface:arayüz
public interface ProductService {//hangi metholarla çalışcağımızı belirttiğimiz yani not ettiğimiz arayüz 
	List<GetAllProductsResponse> getAll(); //Listeleme

	CreateProductResponse add(CreateProductRequest createProductRequest); //veritabanına ekleme

	GetAllProductsResponse getByName(String name); // name'e göre getirme

	GetProductResponse getById(int id); // id'e göre getirme
	//sildiğimiz productun verileri dönmediği için void kullandık
	void deleteProductById (int id); //id'e göre silme
	
	// id ile veritabanından güncellemek isteyeceğim productı getirir.request ile getirdiğim productu güncelleriz
	ProductUpdateResponse updateProductById(int id,UpdateProductRequest request);
}
