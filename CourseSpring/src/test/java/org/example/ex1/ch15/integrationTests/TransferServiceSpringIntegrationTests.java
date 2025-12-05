package org.example.ex1.ch15.integrationTests;

import org.example.sq.part2.ch14.service.TransferService;
import org.example.sq.part2.ch14.model.Account;
import org.example.sq.part2.ch14.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {TransferService.class})
public class TransferServiceSpringIntegrationTests {

    @MockitoBean
    private AccountRepository accountRepository;

    @Autowired
    private TransferService transferService;

    @Test
    void transferServiceTransferAmountTests() {
        Account sender = new Account();
        sender.setId(1);
        sender.setAmount(new BigDecimal(1000));

        Account receiver = new Account();
        receiver.setId(2);
        receiver.setAmount(new BigDecimal(1000));

        when(accountRepository.findById(1L))
                .thenReturn(Optional.of(sender));

        when(accountRepository.findById(2l))
                .thenReturn(Optional.of(receiver));

        transferService.transferMoney(1,2,new BigDecimal(100));

        verify(accountRepository)
                .changeAmount(1,new BigDecimal(900));
        verify(accountRepository)
                .changeAmount(2,new BigDecimal(1100));

    }
}
