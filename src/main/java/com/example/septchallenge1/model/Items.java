package com.example.septchallenge1.model;

import java.util.ArrayList;
import java.util.List;

public class Items {
    private List<Item> itemList;

    public List<Item> getItemList() {
        if(itemList== null) {
            itemList = new ArrayList<>();
        }
        return itemList;
    }

    public Item getItem(String id) {
        Item item = new Item();
        int index;
        for (int i = 0; i < itemList.size(); i++) {
            if(itemList.get(i).getId() == id) {
                index = i;
                break;

            }

        }
        return null;
    }

    public void deleteItems() {
        itemList.clear();
    }
    public void setItemList(List<Item> itemList) { this.itemList = itemList;}
}
