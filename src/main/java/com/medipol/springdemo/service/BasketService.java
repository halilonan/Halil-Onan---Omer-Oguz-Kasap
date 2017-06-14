package com.medipol.springdemo.service;

import com.medipol.springdemo.model.Basket;
import com.medipol.springdemo.model.BasketItem;
import com.medipol.springdemo.model.Product;
import org.springframework.stereotype.Service;

@Service

public class BasketService {

    private Basket basket = new Basket();



    public void createBasket() {
        basket = new Basket();
    }

    public void printBasketDetail() {
        for (BasketItem basketItem:basket.getItems()){

            System.out.println("Product Name:"+basketItem.getProduct().getName()+ " Quantity"+basketItem.getQuantity());
        }
    }

    public void addProduct(Product product, Integer quantity){
        BasketItem basketItem = new BasketItem(quantity,product);
        basket.addItem(basketItem);

    }

    public void removeProduct(Product product){
        for (int i = 0; i < basket.getItems().size(); i++) {
            if ((basket.getItems().get(i).getProduct().equals(product))){
                basket.getItems().remove(basket.getItems().get(i));
            }
        }
    }

    public void incrementQuantity(Product product, Integer quantity) {
        for (BasketItem basketItem : basket.getItems()) {
            if (basketItem.getProduct().equals( product )) {
                basketItem.setQuantity( basketItem.getQuantity() + quantity );
            }
        }
    }

    public void decrementQuantity(Product product, Integer quantity){
        for (BasketItem basketItem:basket.getItems()){
            if (basketItem.getProduct().equals(product)){
                basketItem.setQuantity(basketItem.getQuantity()-quantity);
            }
        }
    }
    public void decrementQuantityZeroRemove(Product product, Integer quantity){
        for (BasketItem basketItem:basket.getItems()){
            if (basketItem.getProduct().equals(product)){
                if (basketItem.getQuantity()- quantity <= 0){
                    removeProduct(basketItem.getProduct());
                }else {
                    basketItem.setQuantity(basketItem.getQuantity()-quantity);
                }
                break;
            }
        }
    }

    public Basket getBasket() {return basket;}
    public Integer getBasketPrice() {return basket.calculateBasketPrice();}
}
