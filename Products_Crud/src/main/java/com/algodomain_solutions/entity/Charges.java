package com.algodomain_solutions.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="charge")
public class Charges {
     @Id
     @GeneratedValue(strategy =GenerationType.IDENTITY)
	 private long charegeId;
     private float gst;
	 private float delivery;  
	 
     @ManyToOne
     private Product product;
     
	 public long getCharegeId() {
		return charegeId;
	}
	public void setCharegeId(long charegeId) {
		this.charegeId = charegeId;
	}
	public float getGst() {
		return gst;
	}
	public void setGst(float gst) {
		this.gst = gst;
	}
	public float getDelivery() {
		return delivery;
	}
	public void setDelivery(float delivery) {
		this.delivery = delivery;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

}
