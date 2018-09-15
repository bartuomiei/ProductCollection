package com.example.ProductsCollection.service;

import com.example.ProductsCollection.model.Product;
import com.example.ProductsCollection.repository.StaticProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private StaticProductRepository productDataBase;

    @Override
    public void save(Product product) {

        if(product.getId() == 0){
            productDataBase.save(product);
        }else{
            productDataBase.update(product);
        }
    }

    @Override
    public void update(Product product) {
        productDataBase.update(product);
    }

    @Override
    public void remove(Product product) {
        productDataBase.remove(product);
    }

    @Override
    public Product findByID(int productId) {
        return productDataBase.findByID(productId);
    }

    @Override
    public List<Product> getListOfProducts() {
        return productDataBase.getListOfProducts();
    }
}
