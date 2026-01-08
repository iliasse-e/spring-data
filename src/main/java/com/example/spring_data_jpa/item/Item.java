package com.example.spring_data_jpa.item;

import com.example.spring_data_jpa.retailer.Retailer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Item {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String code;

  private int quantity;

  @ManyToOne
  private Retailer retailer;

  public Item() {};

  public Item(String name, String code, int quantity) {
    this.name = name;
    this.code = code;
    this.quantity = quantity;
  };

  public String getName() {
    return this.name;
  }

  public Long getId() {
    return this.id;
  }

  public String getCode() {
    return this.code;
  }

  public int getQuantity() {
    return this.quantity;
  }

  public Retailer getRetailer() {
    return retailer;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setCode(String c) {
    this.code = c;
  }

  public void setQuantity(int qt) {
    this.quantity = qt;
  }

  public void setRetailer(Retailer retailer) {
    this.retailer = retailer;
  }
}