package org.example.sq.part2.ch12.controllers;

import org.example.sq.part2.ch12.model.Purchase;
import org.example.sq.part2.ch12.repositories.PurchaseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    private final PurchaseRepository purchaseRepository;

    public PurchaseController(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @PostMapping
    private void storePurchase(@RequestBody Purchase purchase) {
        purchaseRepository.storePurchase(purchase);
    }

    @GetMapping
    private List<Purchase> findPurchases(){
        return purchaseRepository.getPurchase();
    }

}
