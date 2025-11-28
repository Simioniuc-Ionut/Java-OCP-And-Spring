package org.example.sq.part1.SmartHomeController.repository.lightRepository;

import jakarta.annotation.PostConstruct;
import org.example.sq.part1.SmartHomeController.dto.LightingRequestDTO;
import org.example.sq.part1.SmartHomeController.model.lightning.Colors;
import org.example.sq.part1.SmartHomeController.model.lightning.LightEntity;
import org.example.sq.part1.SmartHomeController.model.lightning.LightLocation;
import org.example.sq.part1.SmartHomeController.model.lightning.LightType;

import java.util.*;
import java.util.stream.IntStream;

public class LightInMemoryRepository implements LightRepository {
    private static Map<Long,LightEntity> lightEntityMap;
    @PostConstruct
    public void init(){
        lightEntityMap = new LinkedHashMap<>();

        LightEntity lightEntity1 = LightEntity.builder()
                .id(1)
                .lightLocation(LightLocation.BATHROOM)
                .lightType(LightType.LAMP)
                .brand("Filips")
                .brightness(23.5)
                .colors(Colors.BLUE)
                .name("Some lighting name")
                .wifiConnection("Digi 123")
                .open(false)
                .build();

        LightEntity lightEntity2 = LightEntity.builder()
                .id(2)
                .lightLocation(LightLocation.KITCHEN)
                .lightType(LightType.CEILING)
                .brand("Samsung")
                .brightness(75.0)
                .colors(Colors.WHITE)
                .name("Kitchen Ceiling Light")
                .wifiConnection("Home WiFi")
                .open(true)
                .build();

        LightEntity lightEntity3 = LightEntity.builder()
                .id(3)
                .lightLocation(LightLocation.LIVING_ROOM)
                .lightType(LightType.LAMP)
                .brand("Xiaomi")
                .brightness(50.0)
                .colors(Colors.RED)
                .name("Living Room Lamp")
                .wifiConnection("LivingNet")
                .open(false)
                .build();

        lightEntityMap.put(lightEntity1.getId(),lightEntity1);
        lightEntityMap.put(lightEntity2.getId(),lightEntity2);
        lightEntityMap.put(lightEntity3.getId(),lightEntity3);
    }

    public LightInMemoryRepository(){}

    @Override
    public List<LightEntity> findAll() {
        return new ArrayList<>(lightEntityMap.values());
    }

    @Override
    public LightEntity findById(long id) {
        return lightEntityMap.get(lightEntityMap.values().stream().map(LightEntity::getId).filter(xId -> xId == id).findFirst().orElseThrow(() ->new IllegalArgumentException("The lighter with id ="
                + id + " doesn't exist")));
    }

    @Override
    public boolean tryAdd(LightingRequestDTO lightEntity) {
        try {
            addNewLightEntityToMap(lightEntity, lightEntityMap);
        } catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean tryAddAll(LightingRequestDTO... listLightEntities) {
        Map<Long, LightEntity> copyOfOriginalMap = new HashMap<>(lightEntityMap);

        try {
            for(var lightEntity : listLightEntities) {
                addNewLightEntityToMap(lightEntity, copyOfOriginalMap);
            }
        } catch (Exception e){
            return false;
        }
        lightEntityMap = copyOfOriginalMap;
        return true;
    }

    @Override
    public boolean tryRemove(long id){
        try {
            lightEntityMap.remove(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean tryRemoveAll(){
        Map<Long, LightEntity> copyOfOriginalMap = new HashMap<>(lightEntityMap);
        try {
            for(var lightEntity : copyOfOriginalMap.values()) {
                tryRemove(lightEntity.getId());
            }
        } catch (Exception e){
            lightEntityMap=copyOfOriginalMap;
            return false;
        }
        return true;
    }

    @Override
    public void tryUpdate(LightEntity entity) {
        Map<Long, LightEntity> copyOfOriginalMap = new HashMap<>(lightEntityMap);
        try{
            lightEntityMap.put(entity.getId(),entity);
        } catch (Exception e) {
            lightEntityMap = copyOfOriginalMap;
        }
    }

    private void addNewLightEntityToMap(LightingRequestDTO lightEntity, Map<Long, LightEntity> lightEntityMap) {
        LightEntity newLight = LightEntity.builder()
                .id(IntStream.range(0, Integer.MAX_VALUE)
                        .filter(x -> lightEntityMap.values().stream().noneMatch(y -> y.getId() == x))
                        .findFirst()
                        .getAsInt())
                .lightLocation(lightEntity.location())
                .lightType(lightEntity.type())
                .name(lightEntity.name())
                .brand(lightEntity.brand())
                .open(lightEntity.open())
                .colors(lightEntity.colors() != null ? lightEntity.colors() : Colors.WHITE)
                .brightness(lightEntity.brightness())
                .wifiConnection(lightEntity.wifiConnection())
                .build();
        lightEntityMap.put(newLight.getId(), newLight);
    }
}
