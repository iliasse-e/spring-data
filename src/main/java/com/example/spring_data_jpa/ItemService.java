package com.example.spring_data_jpa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

  @Autowired
  ItemRepository itemRepository;
  
  public Item save(Item item) {
    return itemRepository.save(item);
  }

  public Optional<Item> findById(Long id) {
    return itemRepository.findById(id);
  }

}
