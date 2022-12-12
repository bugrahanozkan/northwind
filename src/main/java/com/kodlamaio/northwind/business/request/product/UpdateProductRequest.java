package com.kodlamaio.northwind.business.request.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

//Request parametre olarak veririz.Update ve add işlemlerinde kullanırız

public class UpdateProductRequest {//güncellemek istediğim productun bilgilerini bize gösterir.id'yi product sınıfında stratejisini otomatik artırdığımız için güncelllerken idsini güncelleyemeyiz.
	   private String name;
	   private double unitPrice;
	   private int unitInStock;
	   private int categoryId;
}
