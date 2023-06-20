package com.pizzaordering.model;

import javax.persistence.Column;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "address")
public class Address extends BaseEntity {

//	@org.hibernate.annotations.ForeignKey(name="users_id")
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private Users users;

	@Column(length = 10)
	private String houseNo;

	@Column(length = 50)
	private String street;

	@Column(name = "city", length = 25)
//	@NotBlank(message = "State name can't be blank")
	private String city;

	@Column(length = 25)
	private String country;

	@Column(length = 10)
//	@NotBlank(message = "Last  name can't be blank")
	private String pincode;

	@Column(length = 25)
	private String state;
}
