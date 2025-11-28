package org.example.sq.part1.SmartHomeController.services;

import java.time.Duration;
import java.time.LocalDateTime;

public interface ScheduleTimerControl {
    LocalDateTime getExpirationDateTime();

    default boolean isExpired() {
        return LocalDateTime.now().isAfter(getExpirationDateTime());
    }

    default Duration remainingTime() {
        return Duration.between(LocalDateTime.now(), getExpirationDateTime());
    }
}
