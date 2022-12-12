package com.kodlamaio.northwind.business.request.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveOrderRequest {//eklemek istediğimiz siparişin hangi müşteriye ait oldıuğunu belirtmek için kullanırız.diğer iki field(localDatetime ve orderId otomatik olarak spring tarafından oluşturulur.
private int employeeId;
}
