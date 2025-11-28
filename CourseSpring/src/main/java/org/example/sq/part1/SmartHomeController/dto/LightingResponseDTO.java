package org.example.sq.part1.SmartHomeController.dto;

import org.example.sq.part1.SmartHomeController.model.lightning.Colors;
import org.example.sq.part1.SmartHomeController.model.lightning.LightEntity;
import org.example.sq.part1.SmartHomeController.model.lightning.LightLocation;
import org.example.sq.part1.SmartHomeController.model.lightning.LightType;
import org.example.sq.part1.SmartHomeController.services.ScheduleTimerControl;

public record LightingResponseDTO(long id,
                                 String name,
                                 String brand,
                                 LightType type,
                                 LightLocation location,
                                 boolean open,
                                 Colors colors,
                                 double brightness,
                                 String wifiConnection,
                                 ScheduleTimerControl timer){
    public static LightingResponseDTO from(LightEntity entity) {
        return new LightingResponseDTO(
                entity.getId(),
                entity.getName(),
                entity.getBrand(),
                entity.getLightType(),
                entity.getLightLocation(),
                entity.getOpen(),
                entity.getColors(),
                entity.getBrightness(),
                entity.getWifiConnection(),
                entity.getTimer()
        );
    }

}
