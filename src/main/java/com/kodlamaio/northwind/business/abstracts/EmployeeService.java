package com.kodlamaio.northwind.business.abstracts;

import java.util.List;

import com.kodlamaio.northwind.business.request.employee.DeleteEmployeeRequest;
import com.kodlamaio.northwind.business.request.employee.SaveEmployeeRequest;
import com.kodlamaio.northwind.business.request.employee.UpdateEmployeeRequest;
import com.kodlamaio.northwind.business.response.EmployeeResponse;
import com.kodlamaio.northwind.business.response.EmployeeUpdateResponse;

public interface EmployeeService {

	public List<EmployeeResponse> getAllEmloyees();
	
	
	public EmployeeResponse addEmployee(SaveEmployeeRequest request);
	
	
	EmployeeResponse getById(int id); 
	
	
	void deleteEmployeeById (DeleteEmployeeRequest deleteEmployeeRequest);
	
	
	EmployeeUpdateResponse updateEmployeeById(int id,UpdateEmployeeRequest request);

}
