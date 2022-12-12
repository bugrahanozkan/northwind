package com.kodlamaio.northwind.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.northwind.business.abstracts.EmployeeService;
import com.kodlamaio.northwind.business.concretes.EmployeeManager;
import com.kodlamaio.northwind.business.request.employee.DeleteEmployeeRequest;
import com.kodlamaio.northwind.business.request.employee.SaveEmployeeRequest;
import com.kodlamaio.northwind.business.request.employee.UpdateEmployeeRequest;
import com.kodlamaio.northwind.business.response.EmployeeResponse;
import com.kodlamaio.northwind.business.response.EmployeeUpdateResponse;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/v1/employees")

public class EmployeeControler {
	private EmployeeService employeeService;

	public EmployeeControler(EmployeeManager employeeManager){
		this.employeeService = employeeManager;
	}
@GetMapping("/getAll")
 public List<EmployeeResponse> getAll(){                             
      return employeeService.getAllEmloyees();                                  
}

@PostMapping("/add")
public EmployeeResponse add(@RequestBody  SaveEmployeeRequest saveEmployeeRequest) {
	return this.employeeService.addEmployee(saveEmployeeRequest);
	 
}

@GetMapping("getById")
public EmployeeResponse getById(int id) {
	return employeeService.getById(id);
}


@DeleteMapping("deleteEmployeeById")
void deleteEmployeeById (@RequestBody DeleteEmployeeRequest deleteEmployeeRequest) {
	employeeService.deleteEmployeeById(deleteEmployeeRequest);
}

// @pathvariable komutunu url adresine girdiğimiz id numarasını bu methodtaki id alanına gönderir
//@requestBody Postman'a girdiğimiz verileri request alanına gönderir
//@putMapping veritabanındaki mevcut verinin güncellenmesini sağlar
 @PutMapping("updateEmployeeById/{id}")
EmployeeUpdateResponse updateEmployeeById(@PathVariable int id, @RequestBody UpdateEmployeeRequest request) {

	return employeeService.updateEmployeeById(id, request);
	
}
}
