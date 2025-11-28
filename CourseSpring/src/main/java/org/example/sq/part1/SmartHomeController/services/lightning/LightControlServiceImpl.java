package org.example.sq.part1.SmartHomeController.services.lightning;

import org.example.sq.part1.SmartHomeController.aop.audit.ToLog;
import org.example.sq.part1.SmartHomeController.aop.validation.ValidationId;
import org.example.sq.part1.SmartHomeController.dto.LightingRequestDTO;
import org.example.sq.part1.SmartHomeController.dto.LightingResponseDTO;
import org.example.sq.part1.SmartHomeController.model.lightning.Colors;
import org.example.sq.part1.SmartHomeController.model.lightning.LightEntity;
import org.example.sq.part1.SmartHomeController.repository.lightRepository.LightRepository;
import org.example.sq.part1.SmartHomeController.services.ScheduleTimerControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("one")
@ToLog
public class LightControlServiceImpl implements LightingControlService {

    final LightRepository lightRepository;

    @Autowired
    public LightControlServiceImpl(LightRepository lightRepository){
        this.lightRepository=lightRepository;
    }

    @Override
    @ValidationId
    public void turnOn(Long... id) {
        var lightEntity = lightRepository.findById(id[0]);
        lightEntity.setOpen(true);
    }

    @Override
    @ValidationId
    public void turnOff(Long... id) {
            var lightEntity = lightRepository.findById(id[0]);
            lightEntity.setOpen(false);
    }

    @Override
    @ValidationId
    public void setBrightness(double value, Long... id) {
            var lightEntity = lightRepository.findById(id[0]);
            lightEntity.setBrightness(value);
    }

    @Override
    @ValidationId
    public void setColor(Colors color, Long... id) {
            var lightEntity = lightRepository.findById(id[0]);
            lightEntity.setColors(color);
    }

    @Override
    @ValidationId
    public void connectWifi(String wifiConnection, Long... id) {
        var lightEntity = lightRepository.findById(id[0]);
        lightEntity.connectWifi(wifiConnection);
    }

    @Override
    @ValidationId
    public void disconnectWifi(Long... id) {
        var lightEntity = lightRepository.findById(id[0]);
        lightEntity.disconnectWifi();
    }

    @Override
    @ValidationId
    @ToLog
    public String checkWifiConnection(Long... id) {
        return lightRepository.findById(id[0]).checkWifiConnection();
    }

    @Override
    public boolean addLight(LightingRequestDTO... lightingRequestDTO){
       return lightRepository.tryAdd(lightingRequestDTO[0]);
    }

    @Override
    public boolean removeLight(Long... id) {
        return lightRepository.tryRemove(id[0]);
    }

    @Override
    public List<LightingResponseDTO> getLight(Long... id) {
        Long validateId ;
        try{
            LightEntity entity = lightRepository.findById(id[0]);
            return  List.of(LightingResponseDTO.from(entity));
        } catch (Exception e){
            // it doesn't exist.
            return List.of();
        }
    }

    @Override
    @ValidationId
    public boolean scheduleTimer(ScheduleTimerControl timer, Long... id) {
        try{
            LightEntity entity = lightRepository.findById(id[0]);
            entity.setTimer(timer);
            lightRepository.tryUpdate(entity);
            return true;
        } catch (Exception e){
            return false;
        }
    }

}
