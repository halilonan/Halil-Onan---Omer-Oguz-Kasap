package com.medipol.springdemo;


import com.medipol.springdemo.model.Basket;
import com.medipol.springdemo.model.BasketItem;
import com.medipol.springdemo.model.Product;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BasketTest {

    @Test
    public void shouldAddProductWithOneQuantity() throws Exception {

        final Basket basket = new Basket();
        final Product product = new Product(1, "nike air", 200);

        basket.addItem(new BasketItem(1, product));

        assertTrue(basket.getItems().size() == 1);
        for (int i = 0; i < basket.getItems().size(); i++) {
            assertTrue(basket.getItems().get(i).getQuantity() == 1);
        }
    }

    @Test
    public void shouldAddProductWithTwoQuantity() throws Exception {

        final Basket basket = new Basket();
        final Product product = new Product(1, "nike air", 200);

        basket.addItem(new BasketItem(2, product));

        assertTrue(basket.getItems().size() == 1);
        for (int i = 0; i < basket.getItems().size(); i++) {
            assertTrue(basket.getItems().get(i).getQuantity() == 2);
        }
    }

    @Test
    public void shouldAddTwoDifferentProduct() throws Exception {
        final Basket basket = new Basket();
        final Product product = new Product(1, "nike air", 200);
        final Product product2 = new Product(2, "addidas", 400);


        basket.addItem(new BasketItem(1,product));
        basket.addItem(new BasketItem(2,product2));


        assertTrue(basket.getItems().size() == 2);
        assertTrue(basket.getItems().get(0).getProduct().getName()!=basket.getItems().get(1).getProduct().getName());

    }

    @Test
    public void shouldCalculateBasketPriceWithOneProductOneQuantity() throws Exception {

        final Basket basket = new Basket();
        final Product product = new Product(1, "nike air", 200);


        basket.addItem(new BasketItem(1, product));
        int price = basket.calculateBasketPrice();

        assertTrue(basket.getItems().get(0).getQuantity()==1);
        assertTrue(basket.getItems().get(0).getProduct()==product);
        assertTrue(price == 200);
    }

    @Test
    public void shouldCalculateBasketPriceWithOneProductTwoQuantity() throws Exception {

        final Basket basket = new Basket();
        final Product product = new Product(1, "nike air", 200);


        basket.addItem(new BasketItem(2, product));
        int price = basket.calculateBasketPrice();


        assertTrue(basket.getItems().get(0).getQuantity()==2);
        assertTrue(basket.getItems().get(1).getProduct()==product);
        assertTrue(price == 200);

    }

    @Test
    public void shouldCalculateBasketPriceWithMultipleProduct() throws Exception {
        final Basket basket = new Basket();
        final Product product = new Product(1, "nike air", 200);
        final Product product2 = new Product(2, "addidas", 400);


        basket.addItem(new BasketItem(1, product));
        basket.addItem(new BasketItem(1, product2));
        int price = basket.calculateBasketPrice();

        assertTrue(basket.getItems().size() == 2);
        assertTrue(price ==600);
    }

    @Test
    public void shouldUpdateBasketItemQuantity() throws Exception {
        final Basket basket = new Basket();
        final Product product = new Product(1, "nike air", 200);
        final BasketItem basketItem = new BasketItem(5, product);//burada update edilecek quantity belirlenir.

        basket.addItem(new BasketItem(1,product));
        basket.getItems().set(0,basketItem);                            //burada index e göre quantity update edilir.

        assertTrue(basket.getItems().get(0).getQuantity()==5);
        assertTrue(basket.getItems().size() == 1);
    }

}