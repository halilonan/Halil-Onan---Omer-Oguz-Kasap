package com.medipol.springdemo.service;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ProductServiceTest {

    @Test
    public void shouldListInitialProducts() throws Exception {
        final ProductService productService = new ProductService();
        productService.list();
        assertTrue(productService.list().size() == 2);
    }

    @Test
    public void shouldAddOneProduct() throws Exception {

        ProductService productService = new ProductService();
        productService.add(5, "nika" , 1);
        assertTrue(productService.list().size() == 3);
    }

    @Test
    public void shouldAddMultipleProduct () throws Exception {


        ProductService productService = new ProductService();
        productService.add( 5,"iphone", 5 );
        productService.add( 7,"samsung", 3 );

        assertTrue(productService.list().size() == 4);

    }

    @Test
    public void shouldDeleteProductById() throws Exception {

        ProductService productService = new ProductService();
        productService.delete( 22 );
        assertTrue(productService.list().size() == 1 );

    }

    @Test
    public void shouldUpdateProductName() throws Exception {
        final ProductService productService = new ProductService();
        productService.updateName(22, "puma");

        assertTrue(productService.findBy(22, "puma" )== true);

    }

    @Test
    public void shouldUpdateProductPrice() throws Exception {
        final ProductService productService = new ProductService();
        productService.updatePrice(22,500);

        assertTrue(productService.findBy2(22, 500 )== true);
    }

    @Test
    public void shouldUpdateProductNameAndPrice() throws Exception {

        final ProductService productService = new ProductService();
        productService.updateNameAndPrice(22, "ASUS", 500);

        assertTrue(productService.findBy3(22, "ASUS", 500 )== true);
    }
}