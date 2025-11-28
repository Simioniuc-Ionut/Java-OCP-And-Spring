package org.example.sq.part1.SmartHomeController.services.lightning;

import org.example.sq.part1.SmartHomeController.aop.audit.ToLog;
import org.example.sq.part1.SmartHomeController.aop.validation.ValidationId;
import org.example.sq.part1.SmartHomeController.dto.LightingRequestDTO;
import org.example.sq.part1.SmartHomeController.dto.LightingResponseDTO;
import org.example.sq.part1.SmartHomeController.model.lightning.Colors;
import org.example.sq.part1.SmartHomeController.model.lightning.LightEntity;
import org.example.sq.part1.SmartHomeController.repository.lightRepository.LightRepository;
import org.example.sq.part1.SmartHomeController.services.ScheduleTimerControl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier("many")
@ToLog
public class GroupLightControlServiceImpl implements LightingControlService {
    List<LightEntity> listOfLights;
    final LightRepository lightRepository;

    public GroupLightControlServiceImpl(LightRepository repository) {
        this.lightRepository = repository;
        this.listOfLights = repository.findAll();
    }

    public void addListOfLights(List<LightEntity> listOfLights) {
        this.listOfLights = listOfLights;
    }

    public void addListOfLights(Long... ids) {
        for (long eachId : ids) {
            this.listOfLights.add(lightRepository.findById(eachId));
        }
    }

    public void addListOfLights(String wifiConnection) {
        this.listOfLights = lightRepository.findAll().stream().filter(x -> x.checkWifiConnection().equals(wifiConnection)).toList();
    }

    @Override
    @ValidationId
    public void turnOn(Long... id) {
        listOfLights.forEach(x -> x.setOpen(true));
    }

    @Override
    @ValidationId
    public void turnOff(Long... id) {
        listOfLights.forEach(x -> x.setOpen(false));
    }

    @Override
    @ValidationId
    public void setBrightness(double value, Long... id) {
        listOfLights.forEach(x -> x.setBrightness(value));
    }

    @Override
    @ValidationId
    public void setColor(Colors color, Long... id) {
        listOfLights.forEach(x -> x.setColors(color));
    }

    @Override
    @ValidationId
    public void connectWifi(String wifiConnection, Long... id) {
        listOfLights.forEach(x -> x.connectWifi(wifiConnection));
    }

    @Override
    @ValidationId
    public void disconnectWifi(Long... id) {
        listOfLights.forEach(LightEntity::disconnectWifi);
    }

    @Override
    @ValidationId
    public String checkWifiConnection(Long... id) {
        return listOfLights.stream()
                .map(LightEntity::checkWifiConnection)
                .allMatch(x -> x.equals(listOfLights.getFirst().checkWifiConnection()))
                ? listOfLights.getFirst().checkWifiConnection()
                : "All lights are not connected together!";
    }

    @Override
    public boolean addLight(LightingRequestDTO... lightingRequestDTO) {
        return lightRepository.tryAddAll(lightingRequestDTO);
    }

    @Override
    public boolean removeLight(Long... id) {
        return lightRepository.tryRemoveAll();
    }

    @Override
    public List<LightingResponseDTO> getLight(Long... ids) {
        List<Long> validateIds = new ArrayList<>();
        for(Long id: ids){
            try{
                lightRepository.findById(id);
                validateIds.add(id);
            }catch (Exception e){
                // it doesn't exist. We simply don't add it.
            }
        }

        return validateIds.stream()
                .map(x->lightRepository.findById(x))
                .map(LightingResponseDTO::from)
                .toList();

    }

    @Override
    public boolean scheduleTimer(ScheduleTimerControl timer,Long... ids) {
        try {
            List<LightEntity> lightEntityList = lightRepository.findAll();
            for(Long id : ids) {
                LightEntity entity = lightRepository.findById(id);
                entity.setTimer(timer);
                lightRepository.tryUpdate(entity);
            }
            return true;
        } catch (IllegalArgumentException a) {
            return true;
        }
        catch (Exception e ) {
            return false;
        }
    }

}
