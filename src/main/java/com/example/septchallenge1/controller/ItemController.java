package com.example.septchallenge1.controller;

import com.example.septchallenge1.dao.ItemDAO;
import com.example.septchallenge1.model.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @Autowired
    private ItemDAO itemDAO;

    @GetMapping(path = "/item/item", produces = "application/json")
    public Items getItems() { return itemDAO.getAllProducts();}

    

}
