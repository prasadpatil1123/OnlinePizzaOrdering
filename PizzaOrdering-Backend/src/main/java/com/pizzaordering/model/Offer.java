package com.pizzaordering.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "offers")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Offer extends BaseEntity {

	private int discount;

	private Date validForm;

	private Date validUpto;

	@Column(length = 50, unique = true)
	private String code;

	@Column(length = 1000)
	private String termsCondition;

}
