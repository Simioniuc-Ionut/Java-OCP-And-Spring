package org.example.sq.part2.ch10;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public PaymentDetails processPayment(String name, double nr) {
        if (name == null)
            throw new NotEnoughMoneyException();
        return new PaymentDetails(name,nr);
    }
}
