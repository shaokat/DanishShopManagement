package com.shaokat.model;

import java.util.Date;

public class Stock {
	private Product productId;
	private Supplier supplierId;
	private long id;
	private int quantity;
	private double unitPurchasePrice;
	private double unitSalePrice;
	private Date toDate;
	public Product getProductId() {
		return productId;
	}
	public void setProductId(Product productId) {
		this.productId = productId;
	}
	public Supplier getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Supplier supplierId) {
		this.supplierId = supplierId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getUnitPurchasePrice() {
		return unitPurchasePrice;
	}
	public void setUnitPurchasePrice(double unitPurchasePrice) {
		this.unitPurchasePrice = unitPurchasePrice;
	}
	public double getUnitSalePrice() {
		return unitSalePrice;
	}
	public void setUnitSalePrice(double unitSalePrice) {
		this.unitSalePrice = unitSalePrice;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	
	
	

}
