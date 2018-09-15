package com.example.ProductsCollection.repository;

import com.example.ProductsCollection.model.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StaticProductRepositoryImpl implements StaticProductRepository{

    private static Map<Integer, Product> mapOfProducts = new HashMap<Integer, Product>(){
        {
            put(1, new Product(1, "Teddy Bear","Hasbro", 25, "Very cuddly, soft and nice brown bear"));
            put(2, new Product(2, "Volleyball ball", "Mikasa",5, "Original USA Major Baseball League ball, size 4, color white with red stitches"));
            put(3, new Product(3, "Tennis racket", "Head", 65, "Training racket for kids. Medium strings stiffness, medium size"));
            put(4, new Product(4, "Yoyo", "Draco-yoyos", 15, "String length: 1,5m. Color: blue/black, Glowing red diodes when spinning"));
            put(5, new Product(5, "Princess doll", "Barbie", 30, "Pink princess doll, with blonde hair and tiara"));
            put(6, new Product(6, "X-CR Robot", "Hasbro", 40, "50cm tall, makes robot noises, shoots with plastic projectiles"));
        }
    };


    @Override
    public void save(Product product) {

        int nextkey = 0;
        for(int nKey : mapOfProducts.keySet()){
            if(nKey > nextkey){
                    nextkey = nKey;
            }
        }
        int id = nextkey + 1;
        product.setId(id);
        mapOfProducts.put(id, product);
    }

    @Override
    public void update(Product product) {
        mapOfProducts.put(product.getId(), product);
    }

    @Override
    public void remove(Product product) {
        int key = product.getId();
        mapOfProducts.remove(key);
    }

    @Override
    public Product findByID(int productId) {

        for(int nKey : mapOfProducts.keySet()){
            Product nProduct = mapOfProducts.get(nKey);
            if(nProduct.getId() == productId){
                return nProduct;
            }
        }
        return null;
    }

    @Override
    public List<Product> getListOfProducts() {
        return new ArrayList<>(mapOfProducts.values());
    }
}
