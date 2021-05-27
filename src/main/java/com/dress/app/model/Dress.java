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
	private String type;
	private String status;

	public Dress(String name, float price, String imageUrl, String dressCode, String type, String status) {
		super();
		this.name = name;
		this.price = price;
		this.imageUrl = imageUrl;
		this.type = type;
		this.status = status;

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

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
//	@Override
//	public String toString() {
//		return "Dress [id=" + id + ", name=" + name + ", price=" + price + ", imageUrl=" + imageUrl + "]";
//	}

}

