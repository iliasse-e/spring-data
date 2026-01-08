package com.example.spring_data_jpa.retailer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RetailRepository extends JpaRepository<Retailer, Long> {
  
}
