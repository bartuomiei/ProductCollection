package com.example.ProductsCollection.controller;

import com.example.ProductsCollection.model.Product;
import com.example.ProductsCollection.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    private String localDate = LocalDate.now().toString();

    @GetMapping
    public ModelAndView getProductsView(){
        ModelAndView mav = new ModelAndView("products-view");
        mav.addObject("listOfProducts", productService.getListOfProducts());
        mav.addObject("generatedDate", localDate);
        return mav;
    }

    @GetMapping("/add-form")
    public ModelAndView getAddFormView(){
        ModelAndView mav = new ModelAndView("add-edit-form");
        mav.addObject("product", new Product());
        mav.addObject("generatedDate", localDate);
        return mav;
    }

    @PostMapping("/add-edit-form")
    public ModelAndView getPostAddFormView(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult){
        ModelAndView mav = new ModelAndView("add-edit-form");

        if(bindingResult.hasErrors()){
            mav.addObject("product", product);
            mav.setViewName("add-edit-form");
        }else{
            mav.addObject("successMessage", "Action ended successfully!");
            productService.save(product);
            mav.addObject("product", new Product());
        }
        mav.addObject("generatedDate", localDate);
        return mav;
    }

    @GetMapping("/remove-product-id={id}")
    public String removeProduct(@PathVariable("id") int productID){
        Product productToRemove = productService.findByID(productID);
        productService.remove(productToRemove);
        return "redirect:/products";
    }

    @GetMapping("/edit-product-id={id}")
    public ModelAndView editProduct(@PathVariable("id") int productID){
        ModelAndView mav = new ModelAndView("add-edit-form");
        Product productToEdit = productService.findByID(productID);
        mav.addObject("product", productToEdit);
        mav.addObject("generatedDate", localDate);
        return mav;
    }

    @GetMapping("/product-details-id={id}")
    public ModelAndView showProductDetails(@PathVariable("id") int productId){
        ModelAndView mav = new ModelAndView("product-details");
        Product productToShow = productService.findByID(productId);
        mav.addObject("product", productToShow);
        mav.addObject("generatedDate", localDate);
        return mav;
    }





}
