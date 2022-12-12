package com.kodlamaio.northwind.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.northwind.business.abstracts.OrderService;
import com.kodlamaio.northwind.business.concretes.OrderManager;
import com.kodlamaio.northwind.business.request.order.SaveOrderRequest;
import com.kodlamaio.northwind.business.request.order.UpdateOrderRequest;
import com.kodlamaio.northwind.business.response.OrderResponse;
import com.kodlamaio.northwind.business.response.OrderUpdateResponse;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/orders/")
public class OrderController {

	private OrderManager orderManager ;
	private OrderService orderService;

//	public OrderController(OrderManager orderManager) {
//		
//		this.orderManager = orderManager;
//	}
//	
	
	@GetMapping("getAll")
	public List<OrderResponse> getAll( ){
		return orderManager.getAllOrders();
		
	}
	@PostMapping ("add")
	public OrderResponse add(@RequestBody SaveOrderRequest request) {
		return orderService.addOrder(request);
	}
	@GetMapping("getById/{id}")
	public OrderResponse getById(@PathVariable  int id) {
		return orderService.getById(id);
	}
	@DeleteMapping("deleteOrderById/{id}")
	void deleteOrderById (@PathVariable  int id) {
		orderService.deleteOrderById(id);
	}
	@PutMapping("updateOrderById/")
	OrderUpdateResponse updateOrderById(@RequestBody UpdateOrderRequest request) {
		return orderService.updateOrderById(request);

	}
}
