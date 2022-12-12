package com.kodlamaio.northwind.business.request.employee;

import java.util.List;

import com.kodlamaio.northwind.entities.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveEmployeeRequest {

  private String firstName;
  private String lastName;
  private double salary;
 // private List<Order> orderList; //requst:ekleme
}
