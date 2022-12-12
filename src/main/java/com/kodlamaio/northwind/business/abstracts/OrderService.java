package com.kodlamaio.northwind.business.abstracts;

import java.util.List;

import com.kodlamaio.northwind.business.request.order.SaveOrderRequest;
import com.kodlamaio.northwind.business.request.order.UpdateOrderRequest;
import com.kodlamaio.northwind.business.request.product.UpdateProductRequest;
import com.kodlamaio.northwind.business.response.OrderResponse;
import com.kodlamaio.northwind.business.response.OrderUpdateResponse;

public interface OrderService {
	public List<OrderResponse> getAllOrders();// listeleme methodu

	public OrderResponse addOrder(SaveOrderRequest request); // ekleme methodu
	
	
	public OrderResponse getById(int id); // id ye göre order getirdi
	
	
	void deleteOrderById (int id); // id ye göre silme
	
	
	// id ile veritabanında güncellemek istediğim orderı getirir. request ile getirdiğimiz orderı güncelleriz
	OrderUpdateResponse updateOrderById(UpdateOrderRequest request);
}
