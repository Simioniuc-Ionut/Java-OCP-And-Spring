package org.example.sq.part1.SmartHomeController.model.dateTime;

import org.example.sq.part1.SmartHomeController.services.ScheduleTimerControl;

import java.time.LocalDateTime;

public record DateTimer(LocalDateTime expiration) implements ScheduleTimerControl {

    @Override
    public LocalDateTime getExpirationDateTime() {
        return expiration;
    }

    public String toString(){
        return "Date timer expire: " + expiration
                + " is expired? " + isExpired()
                + " time remaining is : " + remainingTime();
    }
}

