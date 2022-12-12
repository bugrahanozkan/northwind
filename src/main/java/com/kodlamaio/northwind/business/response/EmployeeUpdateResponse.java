package com.kodlamaio.northwind.business.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

// Dönüş tiplerinde kullnılır. Entity nesnelerini doğrudan dönmek yerine response nesnesine çevirip döneriz
// entity nesneleri(order,product,category,employee)
//product yerine productResponse order yerine orderResponse gibi  method dönüşleri yapılır.

public class EmployeeUpdateResponse {//güncellenen employee'i döndürür.
private int id ;
private String firstName;
private String lastName;
private double salary;
}
