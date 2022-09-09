package com.example.septchallenge1.controller;

import com.example.septchallenge1.dao.ItemDAO;
import com.example.septchallenge1.model.Item;
import com.example.septchallenge1.model.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URL;
import java.nio.file.Path;

@RestController
public class ItemController {

    @Autowired
    private ItemDAO itemDAO;

    @GetMapping(path = "/item/item", produces = "application/json")
    public Items getItems() { return itemDAO.getAllItems();}

   @GetMapping(path = "/item/item/{id}", produces = "application/json")
    public Item getItem(@PathVariable String id) {

        System.out.println(id);
        return itemDAO.getItem(id);
   }

    @PostMapping(path = "/item/item", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addItem(
            @RequestHeader(name = "X-COM-PERSIST", required = false) String headerPersist,
            @RequestHeader(name = "X-COM-LOCATION", required = false, defaultValue = "ASIA") String headerLocation,
            @RequestBody Item item
    ) throws Exception
    {
        Integer id = itemDAO.getAllItems().getItemList().size() + 1;

        item.setId(id.toString());

        itemDAO.addItem(item);

        URI  location = ServletUriComponentsBuilder.fromCurrentRequest().path("/item/item/{id}").buildAndExpand(item.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

//    @PutMapping(path = "item/item")
        @DeleteMapping(path = "/item/item")
        public void deleteItems() {
            itemDAO.deleteItems();
        }
}
