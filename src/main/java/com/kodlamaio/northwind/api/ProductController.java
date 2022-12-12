package com.kodlamaio.northwind.api;//api paketine controllerimiz oluşturduk

import java.util.List;

import org.springframework.data.convert.ReadingConverter;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.northwind.business.abstracts.ProductService;
import com.kodlamaio.northwind.business.request.product.CreateProductRequest;
import com.kodlamaio.northwind.business.request.product.UpdateProductRequest;
import com.kodlamaio.northwind.business.response.CreateProductResponse;
import com.kodlamaio.northwind.business.response.GetAllProductsResponse;
import com.kodlamaio.northwind.business.response.GetProductResponse;
import com.kodlamaio.northwind.business.response.OrderUpdateResponse;
import com.kodlamaio.northwind.business.response.ProductUpdateResponse;

import lombok.AllArgsConstructor;
@RestController//springboota controller sınıfı olduğunu söyleriz
@RequestMapping("/api/v1/products/")// sorgulayacağımız urlyi belirledik
@AllArgsConstructor

public class ProductController {
 private ProductService productService;//ProductService'de yazmış olduğumuz methodlara erişmek için kullandık
 
 //ProdouctService'de yazmış olduğumuz bütün methodları kontrol etmek için(çalışıp çalışmadığını,test etmek) ProductController oluşturuk
 @GetMapping("getAll")
 public List<GetAllProductsResponse> getAll(){
	 return productService.getAll();
 }
 
 @PostMapping("addProduct")
 public CreateProductResponse add(@RequestBody CreateProductRequest createProductRequest) {
	 return productService.add(createProductRequest);
 }
 
 @GetMapping("getByName")
 public GetAllProductsResponse getByName(@RequestParam String name) {
	 return productService.getByName(name);
 }
 
 @GetMapping("getById/{id}")
 public GetProductResponse getById(@PathVariable  int id) {
	 return productService.getById(id);
 }
 @DeleteMapping("deleteProductById/{id}")
 void deleteProdctById (@PathVariable  int id) {
	 productService.deleteProductById(id);
	 
 }
 @PutMapping("updateProductById/{id}")
public ProductUpdateResponse updateProductById( @PathVariable int id,@RequestBody   UpdateProductRequest request) {
	return productService.updateProductById(id, request);
	
}
 
 
 
 
 
}
