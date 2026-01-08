package com.example.spring_data_jpa.retailer;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Retailer {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String city;

  private Long immatriculation;

  private List<Long> itemIdList;
  
  public Retailer() {}

  public Retailer(String name, String city, Long immatriculation) {
    this.name = name;
    this.city = city;
    this.immatriculation = immatriculation;
  }

  public String getCity() {
    return city;
  }

  public Long getId() {
    return id;
  }

  public Long getImmatriculation() {
    return immatriculation;
  }

  public List<Long> getItemIdList() {
    return itemIdList;
  }

  public String getName() {
    return name;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setImmatriculation(Long immatriculation) {
    this.immatriculation = immatriculation;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void addItemId(Long id) {
    this.itemIdList.add(id);
  }

  public void deleteItemId(Long id) {
    int index = itemIdList.indexOf(id);
    this.itemIdList.remove(index);
  }
}
