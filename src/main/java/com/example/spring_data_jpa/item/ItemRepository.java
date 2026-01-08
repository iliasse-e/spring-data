package com.example.spring_data_jpa.item;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
  List<Item> findByRetailerImmatriculation(Long immatriculation);
}