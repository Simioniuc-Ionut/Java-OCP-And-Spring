package org.example.sq.part2.ch13;

import java.math.BigDecimal;

public record TransferRequest(long senderAccountId, long receiveAccountId, BigDecimal amount) {
}
