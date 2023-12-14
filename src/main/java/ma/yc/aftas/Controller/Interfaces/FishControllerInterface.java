package ma.yc.aftas.Controller.Interfaces;

import ma.yc.aftas.Models.DTO.Impl.FishDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FishControllerInterface {
    ResponseEntity<String> create(FishDTO fishDTO);
    ResponseEntity<String> delete(String name);
    ResponseEntity<FishDTO> get(String name);
    public ResponseEntity<List<FishDTO>> getAll();
}
