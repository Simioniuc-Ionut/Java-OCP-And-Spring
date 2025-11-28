package org.example.sq.part1.SmartHomeController.model.dateTime;

import org.example.sq.part1.SmartHomeController.services.ScheduleTimerControl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record TimeTimer(int hour, int minute) implements ScheduleTimerControl {

    @Override
    public LocalDateTime getExpirationDateTime() {
        LocalDate today = LocalDate.now();
        LocalTime t = LocalTime.of(hour, minute);
        LocalDateTime dateTime = LocalDateTime.of(today, t);

        if (dateTime.isBefore(LocalDateTime.now())) {
            dateTime = dateTime.plusDays(1);
        }

        return dateTime;
    }

    public String toString() {
        return "Time is set at: " + hour + ":" + minute
                +" is expired ? " + isExpired()
                +" timer remaining :" + remainingTime();
    }
}
