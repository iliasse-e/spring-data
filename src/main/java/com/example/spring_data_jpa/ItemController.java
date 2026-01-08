package com.example.spring_data_jpa;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/item")
public class ItemController {

  @Autowired
  ItemService itemService;

  @PostMapping()
  ResponseEntity<Item> save(@RequestBody Item item, UriComponentsBuilder uriBuilder) {
    Item savedItem = itemService.save(item);
    URI uri = uriBuilder.path("/item/{id}").buildAndExpand(savedItem.getCode()).toUri();
    return ResponseEntity.created(uri).body(savedItem);
  }

  @GetMapping(path = "/{id}")
  ResponseEntity<Item> findById(@PathVariable Long id, UriComponentsBuilder uriBuilder) {
    return itemService
            .findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
  }

}
