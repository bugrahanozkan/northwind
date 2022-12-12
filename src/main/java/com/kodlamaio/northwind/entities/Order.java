package com.kodlamaio.northwind.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // order classı ile veritabanındaki orders tablosunu eşitler 
public class Order {
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "date")
	private LocalDateTime date = LocalDateTime.now();

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "employee_id")
	@OnDelete(action = OnDeleteAction.CASCADE) // eeğer employee objesi silinirse bu objeye bağlı bütün orderları da
												// otomatikmen siler
	private Employee employee;
}
