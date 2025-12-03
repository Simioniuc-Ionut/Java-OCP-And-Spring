package org.example.sq.part2.ch11.serviceCallerOpenFeign;

import org.example.sq.part2.ch11.servicePayment.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name="payments" ,
url = "http://localhost:8080")
public interface PaymentsProxy {
    @PostMapping("/payment")
    Payment createPayment(
            @RequestHeader String requestId,
            @RequestBody Payment payment
    );
}
