package com.kodlamaio.northwind.business.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderUpdateResponse {
   private int id;
   private int employeeId;
   private LocalDateTime date;
}
