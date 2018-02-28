package com.zm.model;

import java.util.List;

public class Goods {
	private Long id;
	private String name;
	private String brand;
	private String imgeurl;
	private Double price;
	private String store;
	private List<Attribute> attributes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
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

	public String getImgeurl() {
		return imgeurl;
	}

	public void setImgeurl(String imgeurl) {
		this.imgeurl = imgeurl;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}
}
