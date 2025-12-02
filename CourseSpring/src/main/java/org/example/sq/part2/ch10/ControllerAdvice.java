package org.example.sq.part2.ch10;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<ErrorDetails> handleException() {
        ErrorDetails err = new ErrorDetails();
        err.setMessage("Not enough money to make the payment");
        return ResponseEntity
//                .badRequest()
                .status(HttpStatus.BAD_REQUEST)
                .header("City","Iasi")
                .header("Country","Romania")
                .header("Hello","Bonjour")
                .body(err);
    }
}
