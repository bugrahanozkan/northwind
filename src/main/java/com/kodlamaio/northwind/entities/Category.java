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

@Entity
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Category {
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	// mappedBy komutu yalnızca @OneToMany anatayonunda yazılır.kategorinin one olduğunu springBoota söyler.
	//mappedBy'daki "category" ile product sınıfındaki @ManyToOne'nın altında bulunan "category" ile aynı olmak zorundadır.
	@OneToMany(mappedBy = "category")//her ürünün bir tane kategorisi vardır.her kategorinin birden fazla producutu bulunur
	private List<Product> products;//list sayesinde dinamik olarak eleman ekleyip çıkarabiliriz.
}

