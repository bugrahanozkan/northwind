package com.kodlamaio.northwind.business.response;

import java.util.List;

import com.kodlamaio.northwind.entities.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {

	private int id;
	private String firstName;
	private String lastName;
	private double salary;
	//private List<Order> orderList;//employee çağırırken siparişlerini göstermek istemeyebiliriz
									// response'un olayı benim istediğimiz fieldların dönmesi(örnek sadece firstname dönsün vs..)
}
