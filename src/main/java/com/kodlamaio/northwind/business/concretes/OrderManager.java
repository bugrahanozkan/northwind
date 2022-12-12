package com.kodlamaio.northwind.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlamaio.northwind.business.abstracts.OrderService;
import com.kodlamaio.northwind.business.request.order.SaveOrderRequest;
import com.kodlamaio.northwind.business.request.order.UpdateOrderRequest;
import com.kodlamaio.northwind.business.response.GetOrderResponse;
import com.kodlamaio.northwind.business.response.GetProductResponse;
import com.kodlamaio.northwind.business.response.OrderResponse;
import com.kodlamaio.northwind.business.response.OrderUpdateResponse;
import com.kodlamaio.northwind.dataAccess.OrderRepository;
import com.kodlamaio.northwind.entities.Employee;
import com.kodlamaio.northwind.entities.Order;
import com.kodlamaio.northwind.entities.Product;

@Service
//Müşteri(Employee) olmadan sipariş(Order) YOK !!!!
//Kategori (Category) olmadan ürün(Product) YOK !!!!!
public class OrderManager implements OrderService {
	private OrderRepository orderRepository;
	private EmployeeManager employeeManager;

	public OrderManager(OrderRepository orderRepository, EmployeeManager employeeManager) {

		this.orderRepository = orderRepository;
		this.employeeManager = employeeManager;
	}

	@Override
	public List<OrderResponse> getAllOrders() {
		List<Order> orders = orderRepository.findAll();
		List<OrderResponse> responses = new ArrayList<>();
		for (Order order : orders) {
			OrderResponse orderResponse = new OrderResponse();
			orderResponse.setId(order.getId());
			orderResponse.setDate(order.getDate());
			orderResponse.setEmployeeId(order.getEmployee().getId());
			responses.add(orderResponse);

		}
		return responses;
	}

	@Override
	public OrderResponse addOrder(SaveOrderRequest request) {
		Employee employee = new Employee();

		employee.setId(request.getEmployeeId());
		
		Order order = new Order();
		order.setEmployee(employee);
		
		orderRepository.save(order);
		
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setId(order.getId());
		orderResponse.setEmployeeId(order.getEmployee().getId());
		orderResponse.setDate(order.getDate());

		return orderResponse;
	}

	@Override
	public OrderResponse getById(int id) {
		Order order = orderRepository.findById(id).orElse(null); 
		OrderResponse response = new OrderResponse();
        response.setId(order.getId());
        response.setDate(order.getDate());
        response.setEmployeeId(order.getEmployee().getId());
        
		return response ;
	}

	@Override
	public void deleteOrderById(int id) {
		orderRepository.deleteById(id);
		
	}

	@Override
	public OrderUpdateResponse updateOrderById(UpdateOrderRequest request) {
		Order order= new Order(); // yeni bir order oluşturduk veritabanından getirebilmek için
		order = orderRepository.findById(request.getOrderId()).get();
//		order.setId(request.getOrderId()); // veritabanında güncellemek istediğimiz orderı id ile getirdik
		
		Employee employee = new Employee(); // yeni bir employee oluşturduk (order employeesini set edebilmek için)
		employee.setId(request.getEmployeeId()); // güncelleyeceğimiz orderın employeesini getirdik
		
		//order.setId(request.getId());//getirdiğimiz orderın id sini güncelledik
		order.setEmployee(employee);// sipariş oluşturmak yada güncellemk için müşteri bilgisine( yani id ile) ulaşmalıyım. 
		
		orderRepository.save(order); // yaptığımız değişiklikleri veritabanına kaydettik
		OrderUpdateResponse updateResponse = new OrderUpdateResponse();
		updateResponse.setId(order.getId());
		updateResponse.setDate(order.getDate());
		updateResponse.setEmployeeId(order.getEmployee().getId());
		
		
		return updateResponse;
	}

	

	
}
