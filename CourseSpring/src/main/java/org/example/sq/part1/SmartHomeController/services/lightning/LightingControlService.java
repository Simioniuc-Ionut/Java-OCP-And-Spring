package org.example.sq.part1.SmartHomeController.services.lightning;

import org.example.sq.part1.SmartHomeController.Openable;
import org.example.sq.part1.SmartHomeController.SmartHomeDevice;
import org.example.sq.part1.SmartHomeController.dto.LightingRequestDTO;
import org.example.sq.part1.SmartHomeController.dto.LightingResponseDTO;
import org.example.sq.part1.SmartHomeController.model.lightning.Colors;
import org.example.sq.part1.SmartHomeController.services.ScheduleTimerControl;

import java.util.List;


public interface LightingControlService extends SmartHomeDevice, Openable<Long> {
    void setBrightness(double value, Long... id);
    void setColor(Colors color, Long... id);
    boolean addLight(LightingRequestDTO ... dto);
    boolean removeLight(Long... id);
    List<LightingResponseDTO> getLight(Long... id);
    boolean scheduleTimer(ScheduleTimerControl timer, Long... id);
}
