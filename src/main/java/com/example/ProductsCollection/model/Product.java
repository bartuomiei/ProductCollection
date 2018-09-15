package com.example.ProductsCollection.model;

import org.springframework.stereotype.Component;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Component
public class Product {

    private int id;
    @NotNull
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    @NotNull
    @NotEmpty(message = "Brand cannot be empty")
    private String brand;
    @Digits(integer = 4, fraction = 2, message = "Price must contain max. 4 integral numbers and 2 fraction")
    @Min(1)
    private double price;
    @NotNull
    @NotEmpty(message = "Description cannot be empty")
    private String description;

    public Product(int id, String name, String brand, double price, String description) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.description = description;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
