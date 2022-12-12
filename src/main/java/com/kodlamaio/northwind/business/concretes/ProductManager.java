package com.kodlamaio.northwind.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlamaio.northwind.business.abstracts.CategoryService;
import com.kodlamaio.northwind.business.abstracts.ProductService;
import com.kodlamaio.northwind.business.request.product.CreateProductRequest;
import com.kodlamaio.northwind.business.request.product.DeleteProductRequest;
import com.kodlamaio.northwind.business.request.product.UpdateProductRequest;
import com.kodlamaio.northwind.business.response.CreateProductResponse;

import com.kodlamaio.northwind.business.response.GetAllProductsResponse;
import com.kodlamaio.northwind.business.response.GetProductResponse;
import com.kodlamaio.northwind.business.response.OrderUpdateResponse;
import com.kodlamaio.northwind.business.response.ProductUpdateResponse;
import com.kodlamaio.northwind.core.untities.mapping.RentaCarModelMapperService;
import com.kodlamaio.northwind.dataAccess.ProductRepository;
import com.kodlamaio.northwind.entities.Category;
import com.kodlamaio.northwind.entities.Product;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {//ProductService'de yazmış olduğumuz methodları(getById,deleteProductById vb.) ProductManager'da ProductService'deki boş methodları doldurmak için implements ettik.
	private ProductRepository productRepository;
	private RentaCarModelMapperService modelMapperService;
	

	@Override
	public List<GetAllProductsResponse> getAll() {
		List<GetAllProductsResponse> responseList = new ArrayList<>();//oluşturduğumuz boş listenin içini veritabanın gelmesini istediğimiz fieldlar ile doldurduk.
		for (Product product : productRepository.findAll()) {//productun veritabanında bulunan bütün productları getirir.
			GetAllProductsResponse response = new GetAllProductsResponse(//Veritabanından gelen her bir productu GetAllProductsResponse'a çevirir.
					product.getId(), 
					product.getName(),
					product.getCategory().getName(),
					product.getUnitInStock(), 
					product.getUnitPrice());
			responseList.add(response);//oluşturduğumuz boş listenin içini veritabanın gelmesini istediğimiz fieldlar ile doldurduk.
		}
		return responseList;
	}

	@Override
	public CreateProductResponse add(CreateProductRequest createProductRequest) {//product oluştururuz.
		
		Product product = this.modelMapperService.forRequest().map(createProductRequest,Product.class);
		this.productRepository.save(product);//içini doldurduğumuz productu veritabanına kaydeder.
		CreateProductResponse  response = this.modelMapperService.forResponse().map(product, CreateProductResponse.class);
		return response;
	}

	@Override
	public GetAllProductsResponse getByName(String name) {//product ismine göre getirdik.
		Product product = productRepository.findByName(name);//Product sınıfındaki name fieldlerini getirip işlem yapabillmek için product değişkenine atarız

		GetAllProductsResponse response = new GetAllProductsResponse();//isme göre döndürmek istediğimiz productun döndürürken name ile döndürürüz ama görmek istediğimizde tüm fieldlarını görmek isteriz.
		response.setId(product.getId());
		response.setName(product.getName());
		response.setCategoryName(product.getCategory().getName());
		response.setUnInStock(product.getUnitInStock());
		response.setUnitPrice(product.getUnitPrice());
		return response;
	}

	@Override
	public GetProductResponse getById(int id) {//yukardaki name ile getirmenin id ile getirme versiyonu
		Product product = productRepository.findById(id).orElse(null); 
		GetProductResponse response = new GetProductResponse();
		response.setId(product.getId());
		response.setCategoryName(product.getCategory().getName());
		response.setName(product.getName());
		response.setUnInStock(product.getUnitInStock());
		response.setUnitPrice(product.getUnitPrice());

		return response;
	}

	

	@Override
	public void deleteProductById(int id) {//veritabanında bulunan productlarımızı idsine göre silme
		productRepository.deleteById(id);
		
	}

	@Override
	public ProductUpdateResponse updateProductById(int productId, UpdateProductRequest request) {//productuptade
		Product product = new Product();//yeni bir product oluşturduk.veritabanından getirebilmek için
		product.setId(productId);//veritabanından güncellemek istediğimiz productu id ile getirdik.
		
		Category category = new Category();  // yeni bir kategori oluşturduk(productun kategorisini set edebilmek için)
		category.setId(request.getCategoryId()); // güncelleyeceğimiz productun kategorisini getirdik.
		
		product.setName(request.getName());// getirdiğimiz productun ismini güncelledik
		product.setUnitInStock(request.getUnitInStock());
		product.setUnitPrice(request.getUnitPrice());
		
		product.setCategory(category); //
		
		productRepository.save(product);//yaptığımız değişiklikleri veritabanına kaydedilmesini sağlar.
		
		ProductUpdateResponse productUpdateResponse = new ProductUpdateResponse();// geriye uptadeResponse dönmek için oluşturduk(çünkü method UptadeResponse dönüyor
		
		productUpdateResponse.setId(product.getId()); // product idyi uptade idye çevirdik.
		productUpdateResponse.setName(product.getName());
		productUpdateResponse.setUnitInStock(product.getUnitInStock());
		productUpdateResponse.setUnitPrice(product.getUnitPrice());
		productUpdateResponse.setCategoryId(product.getCategory().getId());
		
		
		
		//method geriye updateResponse döndüğü için güncellediğimiz productu uptadeResponse a dönüştürüp return ettik.
		return productUpdateResponse; 
	}

	

}
