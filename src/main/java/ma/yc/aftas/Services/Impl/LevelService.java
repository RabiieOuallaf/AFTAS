package ma.yc.aftas.Services.Impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.yc.aftas.Mappers.LevelMapper;
import ma.yc.aftas.Models.DTO.Impl.LevelDTO;
import ma.yc.aftas.Models.Entity.LevelEntity;
import ma.yc.aftas.Models.Repositories.LevelRepository;
import ma.yc.aftas.Services.Interface.LevelServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class LevelService implements LevelServiceInterface {
    @Autowired
    private LevelRepository levelRepository;
    /**
     * Create a new level
     * @param levelDTO
     * @return LevelDTO
     *
     */

    @Override
    public LevelDTO create(LevelDTO levelDTO) {
        LevelEntity levelEntity = levelRepository.findByLevel(levelDTO.getLevel());

        if(levelEntity != null){
            log.info("Level already exists");
            return null;
        }
        LevelEntity toBeCreatedLevelEntity = LevelMapper.levelMapper.toEntity(levelDTO);

        LevelEntity createdLevelEntity = levelRepository.save(toBeCreatedLevelEntity);

        if(createdLevelEntity == null){
            log.info("Level can't be inserted to the DB");
            return null;
        }
        return LevelMapper.levelMapper.toDTO(createdLevelEntity);
    }

    /**
     *
     * Delete a level
     * @param level
     * @return boolean
     *
     */

    @Override
    public boolean delete(Integer level) {
        LevelEntity levelEntity = levelRepository.findByLevel(level);

        if(levelEntity == null){
            log.info("Level not found");
            return false;
        }
        levelRepository.delete(levelEntity);
        return true;
    }

    /**
     *
     * Get all levels
     * @return List<LevelDTO>
     *
     */
    @Override
    public List<LevelDTO> getAll() {

        List<LevelEntity> levelEntities = levelRepository.findAll();
        List<LevelDTO> levelDTOS = new ArrayList<>();

        if(levelEntities.isEmpty()){
            log.info("No levels found");
            return null;
        }

        levelEntities.forEach(levelEntity -> {
            levelDTOS.add(LevelMapper.levelMapper.toDTO(levelEntity));
        });
        return levelDTOS;
    }
    /**
     *
     * Get a level
     * @param level
     * @return LevelDTO
     *
     */

    @Override
    public LevelDTO get(Integer level) {
        LevelEntity levelEntity = levelRepository.findByLevel(level);

        if(levelEntity == null){
            log.info("Level not found");
            return null;
        }

        return LevelMapper.levelMapper.toDTO(levelEntity);
    }
}
