package com.kodlamaio.northwind.business.response;

import java.time.LocalDateTime;

import com.kodlamaio.northwind.entities.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {//veritabanından gelen order bilgileri
 private int id ;
 private LocalDateTime date;
 private int employeeId;
 }
