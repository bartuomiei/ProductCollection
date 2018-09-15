package com.example.ProductsCollection.service;

import com.example.ProductsCollection.model.Product;

import java.util.List;

public interface ProductService {

    void save(Product product);
    void update(Product product);
    void remove(Product product);
    Product findByID(int productId);
    List<Product> getListOfProducts();
}
