package com.medipol.springdemo;

import com.medipol.springdemo.model.Product;

import java.util.List;

public interface Medify {

    void createProduct(Integer id, String name, Integer price);
    List<Product> findAllProducts();


}
