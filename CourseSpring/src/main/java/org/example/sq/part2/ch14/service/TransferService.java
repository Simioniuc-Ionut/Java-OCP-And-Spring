package org.example.sq.part2.ch14.service;

import org.example.sq.part2.ch14.model.Account;
import org.example.sq.part2.ch14.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class TransferService {
    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void transferMoney(
            long idSender,
            long idReceiver,
            BigDecimal amount) {

        Account sender =
                accountRepository.findById(idSender)
                        .orElseThrow(() -> new RuntimeException());

        Account receiver =
                accountRepository.findById(idReceiver)
                        .orElseThrow(() -> new RuntimeException());

        BigDecimal senderNewAmount =
                sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount =
                receiver.getAmount().add(amount);

        accountRepository.changeAmount(idSender,
                senderNewAmount);
        accountRepository.changeAmount(idReceiver,
                receiverNewAmount);
    }

    public List<Account> findAccountsByName(String name) {
        return accountRepository.findAccountsByName(name);
    }

    public Iterable<Account> getAllAcounts() {
        return accountRepository.findAll();
    }
}
