package com.kodlamaio.northwind.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.northwind.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
