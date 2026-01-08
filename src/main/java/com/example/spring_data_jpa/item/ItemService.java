package com.example.spring_data_jpa.item;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_data_jpa.retailer.RetailRepository;
import com.example.spring_data_jpa.retailer.Retailer;

@Service
public class ItemService {

  @Autowired
  ItemRepository itemRepository;

  @Autowired
  RetailRepository retailRepository;
  
  public Item save(Item item) {
    Retailer newRetailer = new Retailer();
    newRetailer.setImmatriculation(Math.round(Math.random()));
    Retailer savedRetailer = createRetailer(newRetailer);

    item.setRetailer(savedRetailer);

    return itemRepository.save(item);
  }

  public Optional<Item> findById(Long id) {
    return itemRepository.findById(id);
  }

  public List<Item> findByRetailerImmatriculation(Long immatriculation) {
    return itemRepository.findByRetailerImmatriculation(immatriculation);
  }

  private Retailer createRetailer(Retailer retailer) {
    return retailRepository.save(retailer);
  }

}
