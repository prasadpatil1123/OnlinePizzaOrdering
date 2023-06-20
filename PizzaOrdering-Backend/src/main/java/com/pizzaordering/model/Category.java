package com.pizzaordering.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
//(exclude = "pizzas")
public class Category extends BaseEntity {
	
	 //this name will be automatically add in database
	@Column(name = "category_name", length = 30, unique = true)
	private String categoryName;//this name should be add in postman
	@Column(length = 100)
	private String description;
	
}
