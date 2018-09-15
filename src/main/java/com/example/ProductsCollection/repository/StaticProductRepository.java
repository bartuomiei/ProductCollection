package com.example.ProductsCollection.repository;

import com.example.ProductsCollection.model.Product;

import java.util.List;

public interface StaticProductRepository {

    void save(Product product);
    void update(Product product);
    void remove(Product product);
    Product findByID(int productId);

    List<Product> getListOfProducts();
}
