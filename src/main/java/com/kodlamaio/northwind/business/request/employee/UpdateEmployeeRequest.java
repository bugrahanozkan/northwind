package com.kodlamaio.northwind.business.request.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

//Request parametre olarak veririz.Update ve add işlemlerinde kullanırız
// request nesnelerinde id verilmez. çünkü id kendisi otomatik oluşturulur.
// idyi response nesnelerde yazarız
public class UpdateEmployeeRequest {
	private int id ;
	private String firstName;
	private String lastName;
	private double salary;
}
