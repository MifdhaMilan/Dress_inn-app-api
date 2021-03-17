package com.dress.app.model;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table
public class Dress implements Serializable {

	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (nullable = false)
	private long id;
	private String name;
	private float price;
	private String imageUrl;
	@Column (nullable = false)
	private String dressCode;

	public Dress(String name, float price, String imageUrl, String dressCode) {
		super();
		this.name = name;
		this.price = price;
		this.imageUrl = imageUrl;
		this.dressCode = dressCode;
	}
	public Dress() {
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getDressCode() {
		return dressCode;
	}
	public void setDressCode(String dressCode) {
		this.dressCode = dressCode;
	}
	
	@Override
	public String toString() {
		return "Dress [id=" + id + ", name=" + name + ", price=" + price + ", imageUrl=" + imageUrl + ", dressCode="
				+ dressCode + "]";
	}

}

