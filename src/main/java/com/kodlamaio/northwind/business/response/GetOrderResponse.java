package com.kodlamaio.northwind.business.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOrderResponse {//getbyidye göre veritabanındaki bilgilleri getirir. response=cevap,geri dönüş demek
 private int id ;
}
