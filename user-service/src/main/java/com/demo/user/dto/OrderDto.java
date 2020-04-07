package com.demo.user.dto;

public class OrderDto {
	private int id;
	private String name;
	private String brand;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public OrderDto(int id, String name, String brand) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
	}
	
	@Override
	public String toString() {
		return "OrderDto [id=" + id + ", name=" + name + ", brand=" + brand + "]";
	}
	public OrderDto() {
		
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	
}
