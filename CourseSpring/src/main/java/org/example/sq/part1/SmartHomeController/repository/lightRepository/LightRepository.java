package org.example.sq.part1.SmartHomeController.repository.lightRepository;

import org.example.sq.part1.SmartHomeController.dto.LightingRequestDTO;
import org.example.sq.part1.SmartHomeController.model.lightning.LightEntity;
import java.util.List;

public interface LightRepository {
    List<LightEntity> findAll();
    LightEntity findById(long id);
    boolean tryAdd(LightingRequestDTO lightEntity);
    boolean tryAddAll(LightingRequestDTO... listLightEntities);
    boolean tryRemove(long id);
    boolean tryRemoveAll();
    void tryUpdate(LightEntity entity);
}
