package com.example.demo.models;

import jakarta.persistence.*;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
//	@org.hibernate.validator.constraints.NotBlank(message = "Name is mandatory")
	private String productName;
	private String quntity;
	private ProductType type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getQuntity() {
		return quntity;
	}

	public void setQuntity(String quntity) {
		this.quntity = quntity;
	}

	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}

//	
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getAge() {
		// TODO Auto-generated method stub
		return null;
	}

}
