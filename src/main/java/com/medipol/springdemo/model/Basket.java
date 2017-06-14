package com.medipol.springdemo.model;

import com.medipol.springdemo.model.BasketItem;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<BasketItem> items = new ArrayList<>();

    public void addItem(BasketItem item) {
        items.add(item);
    }

    public List<BasketItem> getItems() {
        return items;
    }

    public Integer calculateBasketPrice() {
        Integer total = 0;
        for (BasketItem basketItem:items){
            total += basketItem.price();
        }
        return total;
    }
}
