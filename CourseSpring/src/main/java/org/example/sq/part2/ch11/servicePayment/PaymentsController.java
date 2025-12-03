package org.example.sq.part2.ch11.servicePayment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class PaymentsController {
    private static Logger logger =
            Logger.getLogger(PaymentsController.class.getName());

    @GetMapping("/log")
    public ResponseEntity<?> log(){
        return ResponseEntity.ok().body("Some message here!");
    }

    @PostMapping("/payment")
    public ResponseEntity<Payment> createPayment(
            @RequestHeader String requestId,
            @RequestBody Payment payment
    ) {
        logger.info("Received request with ID " + requestId +
                " ;Payment Amount: " + payment.getAmount());
        payment.setId(UUID.randomUUID().toString());
        return  ResponseEntity
                .status(HttpStatus.OK)
                .header("requestId", requestId)
                .body(payment);
    }
}
