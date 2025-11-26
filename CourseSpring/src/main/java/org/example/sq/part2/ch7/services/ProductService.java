package org.example.sq.part2.ch7.services;

import org.example.sq.part2.ch7.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    List<Product> productList = new ArrayList<>();

    public void addAll(Product p) {
        productList.add(p);
    }

    public List<Product> getAll(){
        return new ArrayList<>(productList);
    }


}
