package ma.yc.aftas.Controller.Implementations;

import lombok.RequiredArgsConstructor;
import ma.yc.aftas.Controller.Interfaces.FishControllerInterface;
import ma.yc.aftas.Models.DTO.Impl.FishDTO;
import ma.yc.aftas.Models.DTO.Impl.FishReqDTO;
import ma.yc.aftas.Services.Impl.FishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/fish")
public class FishController implements FishControllerInterface {
    @Autowired
    private FishService fishService;

    /**
     * Create a fish
     * @param fishDTO
     * @return ResponseEntity<String>
     * @Endpoint : /api/v1/fish/create
     */

    @PostMapping("/create")
    @Override
    public ResponseEntity<String> create(@RequestBody FishReqDTO fishDTO) {
        if(fishDTO == null){
            return ResponseEntity.badRequest().body("Invalid request");
        }
        FishDTO createdFishDTO = fishService.create(fishDTO);
        if(createdFishDTO == null){
            return ResponseEntity.badRequest().body("Fish can't be created check the logs");
        }
        return ResponseEntity.ok().body("Created fish object :" + createdFishDTO);
    }

    /**
     *
     * @Definiton Delete a fish
     * @param name
     * @return ResponseEntity<String>
     * @Endpoint : /api/v1/fish/delete/{name}
     *
     */

    @DeleteMapping("/delete/{name}")
    @Override
    public ResponseEntity<String> delete(@PathVariable String name) {
        if(name.isEmpty()){
            return ResponseEntity.badRequest().body("Invalid request");
        }
        if(fishService.deleteFish(name)) {
            return ResponseEntity.ok().body("Fish deleted successfully");
        }
        return ResponseEntity.badRequest().body("Fish not found");
    }

    /**
     *
     * @Definiton Get a fish
     * @param name
     * @return ResponseEntity<FishDTO>
     * @Endpoint : /api/v1/fish/get/{name}
     *
     */
    @GetMapping("/get/{name}")
    @Override
    public ResponseEntity<FishDTO> get(@PathVariable String name) {
        if(name.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        FishDTO fishDTO = fishService.getFish(name);
        if(fishDTO == null){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(fishDTO);
    }

    /**
     *
     * @Definiton Get all fishes
     * @return ResponseEntity<List<FishDTO>>
     * @Endpoint : /api/v1/fish/getAll
     *
     */

    @GetMapping("/getAll")
    @Override
    public ResponseEntity<List<FishDTO>> getAll() {
        List<FishDTO> fishDTOS = fishService.getAll();
        if(fishDTOS == null){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(fishDTOS);
    }


}
