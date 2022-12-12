package com.kodlamaio.northwind.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.northwind.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
 Category findByName(String name);//jparepositorynin içerisinde bu komut hazır olarak bulunmadığı için biz tanımladık.
}
