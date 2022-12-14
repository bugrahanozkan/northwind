package com.kodlamaio.northwind.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "employees")
@Data
@AllArgsConstructor//dolu constructorları(fieldlerı) içerir
@NoArgsConstructor// boş constructorları(fieldları) içermez.    constructor=yapıcı method(Employee employee=new Employee)
@Entity
public class Employee {
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "salary")
	private double salary;

	@OneToMany(mappedBy = "employee")
	private List<Order> orders;
}
