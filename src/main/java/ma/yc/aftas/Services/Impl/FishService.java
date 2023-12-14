package ma.yc.aftas.Services.Impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.yc.aftas.Mappers.FishMapper;
import ma.yc.aftas.Models.DTO.Impl.FishDTO;
import ma.yc.aftas.Models.Entity.FishEntity;
import ma.yc.aftas.Models.Repositories.FishRepository;
import ma.yc.aftas.Services.Interface.FishServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FishService implements FishServiceInterface {
    @Autowired
    private final FishRepository fishRepository;

    @Override
    public FishDTO create(FishDTO fishDTO) {
        FishEntity fishEntity = fishRepository.findByName(fishDTO.getName());

        if(fishEntity != null){
            log.info("Fish already exists");
            return null;
        }
        FishEntity toBeCreatedFishEntity = FishMapper.fishMapper.toEntity(fishDTO);

        FishEntity createdFishEntity = fishRepository.save(toBeCreatedFishEntity);

        if(createdFishEntity == null){
            log.info("Fish can't be inserted to the DB");
            return null;
        }
        return FishMapper.fishMapper.toDTO(createdFishEntity);
    }


    @Override
    public boolean deleteFish(String name) {
        FishEntity fishEntity = fishRepository.findByName(name);

        if(fishEntity == null){
            log.info("Fish not found");
            return false;
        }
        fishRepository.delete(fishEntity);
        return true;
    }

    @Override
    public FishDTO getFish(String name) {
        FishEntity fishEntity = fishRepository.findByName(name);

        if(fishEntity == null){
            log.info("Fish not found");
            return null;
        }
        return FishMapper.fishMapper.toDTO(fishEntity);
    }

    @Override
    public List<FishDTO> getAll() {
        List<FishEntity> fishEntities = fishRepository.findAll();
        List<FishDTO> fishDTOS = new ArrayList<>();

        if(fishEntities.isEmpty()){
            log.info("No fish found");
            return null;
        }
        fishEntities.forEach(fishEntity -> {
            fishDTOS.add(FishMapper.fishMapper.toDTO(fishEntity));
        });

        return fishDTOS;

    }
}
