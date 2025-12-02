package org.example.sq.part2.ch10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping("/payment")
    public ResponseEntity<?> makePayment(
            @RequestParam(required = false) String name
    ) {
         PaymentDetails paymentDetails = paymentService.processPayment(name,101.2);
         return ResponseEntity
                 .status(HttpStatus.ACCEPTED)
                 .body(paymentDetails);
    }
}
