package org.example.sq.part2.ch14.controller;

import org.example.sq.part2.ch13.TransferRequest;
import org.example.sq.part2.ch14.model.Account;
import org.example.sq.part2.ch14.service.TransferService;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    private final TransferService transferService;

    public AccountController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public void transferMoney(
            @RequestBody TransferRequest request
            ) {
        transferService.transferMoney(
                request.senderAccountId(),
                request.receiveAccountId(),
                request.amount()
        );
    }

    @GetMapping("/accounts")
    public Iterable<Account> getAllAccounts(
            @RequestParam(required = false) String name
    ) {
        if (name == null) {
            return transferService.getAllAcounts();
        } else {
            return transferService.findAccountsByName(name);
        }
    }
}
