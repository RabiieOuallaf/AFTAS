package ma.yc.aftas.Controller.Implementations;

import lombok.RequiredArgsConstructor;
import ma.yc.aftas.Controller.Interfaces.LevelControllerInterface;
import ma.yc.aftas.Models.DTO.Impl.LevelDTO;
import ma.yc.aftas.Models.Entity.LevelEntity;
import ma.yc.aftas.Services.Impl.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/level")
public class LevelController implements LevelControllerInterface {

    @Autowired
    private LevelService levelService;

    /**
     * @Definition Create a level
     * @param levelDTO
     * @return ResponseEntity<String>
     * @Endpoint : /api/v1/level/create
     */
    @PostMapping("/create")
    @Override
    public ResponseEntity<String> create(LevelDTO levelDTO) {
        if(levelDTO == null) {
            return ResponseEntity.badRequest().body("Invalid request");
        }
        LevelDTO createdLevelDTO = levelService.create(levelDTO);
        if(createdLevelDTO == null) {
            return ResponseEntity.badRequest().body("Level can't be created check the logs");
        }
        return ResponseEntity.ok().body("Created level object :" + createdLevelDTO);
    }

    /**
     * @Definition Delete a level
     * @param level
     * @return ResponseEntity<String>
     * @Endpoint : /api/v1/level/delete/{level}
     */
    @PostMapping("/delete/{level}")
    @Override
    public ResponseEntity<String> delete(Integer level) {
        if(level == 0) {
            return ResponseEntity.badRequest().body("Invalid request");
        }
        if(levelService.delete(level)) {
            return ResponseEntity.ok().body("Level deleted successfully");
        }
        return ResponseEntity.badRequest().body("Level can't be deleted check the logs");
    }

    /**
     * @Definition Get all levels
     * @return ResponseEntity<List<LevelDTO>>
     * @Endpoint : /api/v1/level/getAll
     */
    @PostMapping("/getAll")
    @Override
    public ResponseEntity<List<LevelDTO>> getAll() {
        List<LevelDTO> levelDTOS = levelService.getAll();
        return ResponseEntity.ok().body(levelDTOS);
    }

    /**
     * @Definition Get a level
     * @param level
     * @return ResponseEntity<LevelDTO>
     * @Endpoint : /api/v1/level/get/{level}
     */
    @PostMapping("/get/{level}")
    @Override
    public ResponseEntity<LevelDTO> get(Integer level) {
        LevelDTO levelEntity = levelService.get(level);
        return ResponseEntity.ok().body(levelEntity);
    }
}
