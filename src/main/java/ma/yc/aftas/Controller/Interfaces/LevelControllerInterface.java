package ma.yc.aftas.Controller.Interfaces;

import ma.yc.aftas.Models.DTO.Impl.LevelDTO;
import ma.yc.aftas.Models.Entity.LevelEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LevelControllerInterface {
    ResponseEntity<String> create(LevelDTO levelDTO);
    ResponseEntity<String> delete(Integer level);
    ResponseEntity<List<LevelDTO>> getAll();
    ResponseEntity<LevelDTO> get(Integer level);
}
