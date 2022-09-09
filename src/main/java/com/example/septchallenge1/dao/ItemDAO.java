package com.example.septchallenge1.dao;

import com.example.septchallenge1.model.Item;
import com.example.septchallenge1.model.Items;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDAO {
    private static Items list = new Items();

    static
    {
        list.getItemList().add(new Item("01", "Iphone 14", "This is the new iphone", 1299.0));
        list.getItemList().add(new Item("02", "Iphone 14 pro", "This is the new iphone", 1799.0));
        list.getItemList().add(new Item("03", "Iphone 14 pro max", "This is the new iphone",  1999.0));
    }

    public Items getAllProducts() { return list; }

    public void addProduct(Item product) { list.getItemList().add(product);}
}