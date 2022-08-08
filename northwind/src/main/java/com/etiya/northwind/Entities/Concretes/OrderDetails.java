package com.etiya.northwind.Entities.Concretes;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="order_details")
@Data
@IdClass(OrderDetailsId.class)
public class OrderDetails implements Serializable {


	@Id
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	@Id
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@Column(name="unit_price")
	private double unitPrice;


	public OrderDetails() {
		super();
	}

	public OrderDetails( Order order, Product product, double unitPrice) {
		this.order = order;
		this.product = product;
		this.unitPrice = unitPrice;
	}
}
