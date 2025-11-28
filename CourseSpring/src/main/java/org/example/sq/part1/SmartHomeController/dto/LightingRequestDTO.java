package org.example.sq.part1.SmartHomeController.dto;

import org.example.sq.part1.SmartHomeController.model.lightning.Colors;
import org.example.sq.part1.SmartHomeController.model.lightning.LightLocation;
import org.example.sq.part1.SmartHomeController.model.lightning.LightType;

public record LightingRequestDTO(String name,
                      String brand,
                      LightType type,
                      LightLocation location,
                      boolean open,
                      Colors colors,
                      double brightness,
                      String wifiConnection) {
    }

