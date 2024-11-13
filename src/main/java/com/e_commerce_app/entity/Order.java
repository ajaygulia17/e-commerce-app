package com.e_commerce_app.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@ManyToOne
	private User user;

	@OneToMany(cascade = CascadeType.ALL)
	private List<CartItem> items;

	private BigDecimal totalAmount;

	private Date orderDate;

	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	private enum OrderStatus {
		PENDING, COMPLETED, CANCELED, FAILED
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Order(Long id, User user, List<CartItem> items, BigDecimal totalAmount, Date orderDate, OrderStatus status) {
		super();
		Id = id;
		this.user = user;
		this.items = items;
		this.totalAmount = totalAmount;
		this.orderDate = orderDate;
		this.status = status;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

}
