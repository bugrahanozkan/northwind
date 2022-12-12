package com.kodlamaio.northwind.entities;

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

@Entity //product sınıfı ile veritabanındaki products tablosunu eşitler.
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
	@Column(name = "id")//veritabınındaki sütunun adını belirleriz
	@Id//product sınıfının ıdsi veritabanındaki idye denk geldiğini söylüyoruz
	@GeneratedValue(strategy = GenerationType.IDENTITY)// ıdyi kendi otomatik artırır.biz id vermeyiz
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "unitPrice")
	private double unitPrice;
	@Column(name = "unitInStock")
	private int unitInStock;
	
	
	@ManyToOne//bir categoride birden fazla product olabilir.Many=Product One= Category
	@JoinColumn(name="category_id")
	@OnDelete(action = OnDeleteAction.CASCADE)// categori objesini silersek eğer bağlı bulunduğu product objeleri de otomatik olarak silinir
	private Category category;
}
