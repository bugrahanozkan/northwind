package com.kodlamaio.northwind.business.request.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

//Request parametre olarak veririz.Update ve add işlemlerinde kullanırız
// request nesnelerinde id kullanılmaz 
// bazı durumlarda (uptade için) id değişikliği yapılabilir.
public class UpdateOrderRequest {
private int orderId ;
private int employeeId;
}
