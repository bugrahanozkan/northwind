package com.kodlamaio.northwind.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlamaio.northwind.business.abstracts.EmployeeService;
import com.kodlamaio.northwind.business.request.employee.DeleteEmployeeRequest;
import com.kodlamaio.northwind.business.request.employee.SaveEmployeeRequest;
import com.kodlamaio.northwind.business.request.employee.UpdateEmployeeRequest;
import com.kodlamaio.northwind.business.response.EmployeeResponse;
import com.kodlamaio.northwind.business.response.EmployeeUpdateResponse;
import com.kodlamaio.northwind.dataAccess.EmployeeRepository;
import com.kodlamaio.northwind.entities.Employee;
import com.kodlamaio.northwind.entities.Order;

@Service
public class EmployeeManager implements EmployeeService {
	private EmployeeRepository employeeRepository;

	public EmployeeManager(EmployeeRepository employeeRepository) {

		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<EmployeeResponse> getAllEmloyees() {

		List<EmployeeResponse> responses = new ArrayList<>();
		for (Employee employee : employeeRepository.findAll()) {
			EmployeeResponse employeeResponse = new EmployeeResponse(employee.getId(), employee.getFirstName(),
					employee.getLastName(), employee.getSalary());
			responses.add(employeeResponse);
		}
		return responses;
	}

	@Override
	public EmployeeResponse addEmployee(SaveEmployeeRequest request) {
		Employee employee = new Employee();
		employee.setFirstName(request.getFirstName());
		employee.setLastName(request.getLastName());
		// employee.setOrders(request.getOrderList());
		employee.setSalary(request.getSalary());

		employeeRepository.save(employee);

		EmployeeResponse response = new EmployeeResponse();
		response.setId(employee.getId());
		response.setFirstName(employee.getFirstName());
		response.setLastName(employee.getLastName());
		//response.setOrderList(employee.getOrders());
		response.setSalary(employee.getSalary());
		return response;
	}


	@Override
	public void deleteEmployeeById(DeleteEmployeeRequest deleteEmployeeRequest) {
		employeeRepository.delete(employeeRepository.findById(deleteEmployeeRequest.getId()).get());
	}

	@Override
	public EmployeeUpdateResponse updateEmployeeById(int id, UpdateEmployeeRequest request) {
		Employee employee = new Employee();
		employee.setId(id);
		
		employee.setFirstName(request.getFirstName());
		employee.setLastName(request.getLastName());
		employee.setSalary(request.getSalary());

		
		employeeRepository.save(employee);
		
		EmployeeUpdateResponse employeeUpdateResponse = new EmployeeUpdateResponse();
		employeeUpdateResponse.setId(employee.getId());
		employeeUpdateResponse.setFirstName(employee.getFirstName());
		employeeUpdateResponse.setLastName(employee.getLastName());
		employeeUpdateResponse.setSalary(employee.getSalary());
		return employeeUpdateResponse;
	}

	@Override
	public EmployeeResponse getById(int id) {
		Employee employee = employeeRepository.findById(id).get();
		EmployeeResponse response = new EmployeeResponse();
		response.setId(employee.getId());
		response.setFirstName(employee.getFirstName());
		response.setLastName(employee.getLastName());
		response.setSalary(employee.getSalary());
		
		return response ;
	}

}
