package com.medipol.springdemo.service;

import com.medipol.springdemo.model.Product;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BasketServiceTest {
    @Test
    public void shouldCreateBasket() throws Exception {
        final BasketService basketService = new BasketService();

        basketService.createBasket();
        basketService.printBasketDetail();

        assertTrue(basketService.getBasket() == null);
    }

    @Test
    public void shouldAddProductWithOneQuantity() throws Exception {
        final BasketService basketService = new BasketService();
        final Product product = new Product(1, "addidas", 200);

        basketService.addProduct(product, 1);
        basketService.printBasketDetail();

        for (int i = 0; i < basketService.getBasket().getItems().size(); i++) {
            assertTrue(basketService.getBasket().getItems().get(i).getQuantity() == 1);
        }
        assertTrue(basketService.getBasket().getItems().size() == 1);
    }

    @Test
    public void shouldAddProductWithTwoQuantity() throws Exception {
        final BasketService basketService =new BasketService();
        final Product product = new Product(1, "addidas", 200);

        basketService.addProduct(product, 2);
        basketService.printBasketDetail();

        for (int i = 0; i < basketService.getBasket().getItems().size(); i++) {
            assertTrue(basketService.getBasket().getItems().get(i).getQuantity() == 2);
        }
    }

    @Test
    public void shouldAddMultipleProduct() throws Exception {
        final BasketService basketService =new BasketService();
        final Product product = new Product(1, "addidas", 200);
        final Product product2 = new Product(2, "nike air", 400);

        basketService.addProduct(product, 1);
        basketService.addProduct(product2, 1);
        basketService.printBasketDetail();

        assertTrue(basketService.getBasket().getItems().size() == 2);
    }

    @Test
    public void shouldRemoveProduct() throws Exception {

        final BasketService basketService = new BasketService();
        final Product product = new Product(1, "addidas", 200);
        final Product product2 = new Product(2, "nike air", 400);
        final Product product3 = new Product(3, "puma", 400);


        basketService.addProduct(product, 1);
        basketService.addProduct(product2, 1);
        basketService.addProduct(product3, 1);
        basketService.printBasketDetail();

        basketService.removeProduct(product);

        basketService.printBasketDetail();

        assertTrue(basketService.getBasket().getItems().size() == 2);

    }

    @Test
    public void shouldIncrementBasketItemQuantity() throws Exception {
        final BasketService basketService = new BasketService();
        final Product product = new Product(1, "addidas", 200);
        final Product product2 = new Product(2, "nike air", 400);
        final Product product3 = new Product(3, "puma", 400);


        basketService.addProduct(product, 1);
        basketService.addProduct(product2, 1);
        basketService.addProduct(product3, 1);
        basketService.incrementQuantity(product, 3);
        basketService.printBasketDetail();

        assertTrue(basketService.getBasketPrice() == 1600);
    }

    @Test
    public void shouldDecrementBasketItemQuantity() throws Exception {
        final BasketService basketService = new BasketService();
        final Product product = new Product(1, "addidas", 200);
        final Product product2 = new Product(2, "nike air", 400);
        final Product product3 = new Product(3, "puma", 400);


        basketService.addProduct(product, 4);
        basketService.addProduct(product2, 1);
        basketService.addProduct(product3, 1);
        basketService.decrementQuantity(product, 3);
        basketService.printBasketDetail();

        assertTrue(basketService.getBasketPrice() == 1000);
    }

    @Test
    public void shouldDecrementBasketItemQuantityAndRemoveWhenQuantityZero() throws Exception {
        final BasketService basketService = new BasketService();
        final Product product = new Product(1, "addidas", 200);
        final Product product2 = new Product(2, "nike air", 400);
        final Product product3 = new Product(3, "puma", 400);


        basketService.addProduct(product, 3);
        basketService.addProduct(product2, 1);
        basketService.addProduct(product3, 1);
        basketService.decrementQuantity(product, 3);
        basketService.printBasketDetail();

        assertTrue(basketService.getBasketPrice() == 800);
        assertTrue(basketService.getBasket().getItems().size() == 2);

    }

    @Test
    public void shouldPriceBeZeroWhenBasketIsEmpty() throws Exception {
        final BasketService basketService = new BasketService();
        final Product product = new Product(1, "addidas", 200);
        final Product product2 = new Product(2, "nike air", 400);
        final Product product3 = new Product(3, "puma", 400);


        basketService.addProduct(product, 3);
        basketService.addProduct(product2, 1);
        basketService.addProduct(product3, 1);
        basketService.removeProduct(product);
        basketService.removeProduct(product2);
        basketService.removeProduct(product3);

        basketService.printBasketDetail();

        assertTrue(basketService.getBasketPrice() == 0);
        assertTrue(basketService.getBasket().getItems().size() == 0);
    }

    @Test
    public void shouldCalculateOneProductPrice() throws Exception {
        final BasketService basketService = new BasketService();
        final Product product = new Product(1, "addidas", 200);


        basketService.addProduct(product, 3);
        basketService.printBasketDetail();

        assertTrue(basketService.getBasketPrice() == 600);
        assertTrue(basketService.getBasket().getItems().size() == 1);
    }

    @Test
    public void shouldCalculateMultipleProductPrice() throws Exception {
        final BasketService basketService = new BasketService();
        final Product product = new Product(1, "addidas", 200);
        final Product product1 = new Product(2, "nike air", 400);
        final Product product2 = new Product(3, "puma", 250);

        basketService.addProduct(product, 3);
        basketService.addProduct(product1, 1);
        basketService.addProduct(product2, 4);

        basketService.printBasketDetail();

        assertTrue(basketService.getBasketPrice() == 2000);
        assertTrue(basketService.getBasket().getItems().size() == 3);
    }

    @Test
    public void shouldCalculateOneProductPriceAfterIncrement() throws Exception {
        final BasketService basketService = new BasketService();
        final Product product = new Product(1, "addidas", 200);


        basketService.addProduct(product, 2);
        basketService.incrementQuantity(product, 5);
        basketService.printBasketDetail();

        assertTrue(basketService.getBasketPrice() == 1000);
        assertTrue(basketService.getBasket().getItems().size() == 1);
    }

    @Test
    public void shouldCalculateOneProductPriceAfterDecrement() throws Exception {
        final BasketService basketService = new BasketService();
        final Product product = new Product(1, "addidas", 200);


        basketService.addProduct(product, 9);
        basketService.decrementQuantity(product, 5);
        basketService.printBasketDetail();

        assertTrue(basketService.getBasketPrice() == 800);
        assertTrue(basketService.getBasket().getItems().size() == 1);
    }

    @Test
    public void shouldCalculatePriceWithMultipleProductAndOneQuantityIncrementOperation() throws Exception {
        final BasketService basketService = new BasketService();
        final Product product = new Product(1, "addidas", 200);
        final Product product1 = new Product(2, "nike air", 400);
        final Product product2 = new Product(3, "puma", 250);

        basketService.addProduct(product, 3);
        basketService.addProduct(product1, 1);
        basketService.addProduct(product2, 4);

        basketService.incrementQuantity(product, 8);
        basketService.incrementQuantity(product1, 5);

        basketService.printBasketDetail();

        assertTrue(basketService.getBasketPrice() == 4600);
        assertTrue(basketService.getBasket().getItems().size() == 3);
    }

    @Test
    public void shouldCalculatePriceWithMultipleProductAndOneQuantityDecrementOperation() throws Exception {
        //TODO sepette coklu urun varken ve bir sayi azaltma isleminden sonra price hesaplanmali
        final BasketService basketService = new BasketService();
        final Product product = new Product(1, "addidas", 200);
        final Product product1 = new Product(2, "nike air", 400);
        final Product product2 = new Product(3, "puma", 250);

        basketService.addProduct(product, 8);
        basketService.addProduct(product1, 11);
        basketService.addProduct(product2, 1);

        basketService.decrementQuantity(product, 3);
        basketService.decrementQuantity(product1, 6);

        basketService.printBasketDetail();

        assertTrue(basketService.getBasketPrice() == 3250);
        assertTrue(basketService.getBasket().getItems().size() == 3);
    }


}