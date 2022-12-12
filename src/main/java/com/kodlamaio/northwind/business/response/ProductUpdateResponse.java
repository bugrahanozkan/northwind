package com.kodlamaio.northwind.business.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductUpdateResponse {//productu güncelledikten sonra güncellenmiş productun döndüğü değerler.Güncellenmiş productu döner.
private int id ;
private String name;
private double unitPrice;
private int unitInStock;
private int  categoryId;
}
