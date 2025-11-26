package org.example.sq.part2.ch7.controllers;

import org.example.sq.part2.ch7.Product;
import org.example.sq.part2.ch7.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class ProductController {

    ProductService productService;

    ProductController(ProductService productService) {
        this.productService=productService;
    }

    @GetMapping("/products")
    public String getAll(Model page){
        var products = productService.getAll();
        page.addAttribute("products", products);
        return "product";
    }

    @PostMapping("/products")
    public String addProduct(
            @RequestParam String name,
            @RequestParam double price,
            Model page) {
        Product p = new Product(name, price);
        productService.addAll(p);
        var products = productService.getAll();
        page.addAttribute("products",products);
        return "product";
    }
}
