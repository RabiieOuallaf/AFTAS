package ma.yc.aftas.Controller.Implementations;

import lombok.RequiredArgsConstructor;
import ma.yc.aftas.Controller.Interfaces.HuntingControllerInterface;
import ma.yc.aftas.Models.DTO.Impl.HuntingDTO;
import ma.yc.aftas.Models.DTO.Impl.HuntingReqDTO;
import ma.yc.aftas.Services.Impl.HuntingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/hunt")
public class HuntingController implements HuntingControllerInterface {
    @Autowired
    private final HuntingService huntingService;

    /**
     *
     * @param huntingDTO
     * @return ResponseEntity<String>
     * @description Create a hunting
     * @RequestBody HuntingReqDTO huntingDTO
     * @EndPoint /api/v1/hunt/create
     */

    @PostMapping("/create")
    @Override
    public ResponseEntity<String> create(@RequestBody HuntingReqDTO huntingDTO) {
        if(huntingDTO == null) {
            return ResponseEntity.badRequest().body("Request body can't be empty");
        }
        HuntingDTO createdHuntingDTO = huntingService.create(huntingDTO);

        if(createdHuntingDTO == null) {
            return ResponseEntity.internalServerError().body("an error occurs while creating hunting");
        }
        return ResponseEntity.ok().body("Hunting :" + huntingDTO + "Is created successfully");
    }
    /**
     *
     * @param huntingDTO
     * @return ResponseEntity<String>
     * @description Update a hunting
     * @RequestBody HuntingReqDTO huntingDTO
     * @EndPoint /api/v1/hunt/update
     *
     */

    @PutMapping("/update")
    @Override
    public ResponseEntity<String> update(@RequestBody HuntingReqDTO huntingDTO) {
        if(huntingDTO == null) {
            return ResponseEntity.badRequest().body("Request body can't be empty");
        }
        HuntingDTO updatedHuntingDTO = huntingService.update(huntingDTO);
        if(updatedHuntingDTO == null) {
            return ResponseEntity.internalServerError().body("an error occurs while updating hunting");
        }


        return ResponseEntity.ok().body("Hunting :" + huntingDTO + "Is updated successfully");
    }
    /**
     *
     * @param id
     * @return ResponseEntity<HuntingDTO>
     * @description Get a hunting by id
     * @PathVariable Integer id
     * @EndPoint /api/v1/hunt/get/{id}
     *
     */

    @GetMapping("/get/{id}")
    @Override
    public ResponseEntity<HuntingDTO> get(@PathVariable Integer id) {
        if(id == 0) {
            return ResponseEntity.badRequest().body(null);
        }
        HuntingDTO huntingDTO = huntingService.get(id);
        if(huntingDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(huntingDTO);
    }

    /**
     *
     * @param id
     * @return ResponseEntity<Object>
     * @description Delete a hunting by id
     * @PathVariable Integer id
     * @EndPoint /api/v1/hunt/delete/{id}
     *
     */

    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<Object> deleteHunting(@PathVariable Integer id) {
        HuntingDTO foundHuntingDTO = huntingService.get(id);
        if(foundHuntingDTO == null) {
            return ResponseEntity.notFound().build();
        }
        boolean isDeleted = huntingService.deleteHunting(id);
        if(!isDeleted) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().build();
    }

    /**
     * @return ResponseEntity<List<HuntingDTO>>
     * @description Get all huntings
     * @EndPoint /api/v1/hunt/getAll
     *
     */
    @GetMapping("/getAll")
    @Override
    public ResponseEntity<List<HuntingDTO>> getAll() {
        List<HuntingDTO> huntingDTOS = huntingService.getAll();
        if(huntingDTOS.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(huntingDTOS);
    }

    /**
     *
     * @param member_id
     * @return ResponseEntity<List<HuntingDTO>>
     * @description Get all huntings by member
     * @PathVariable Integer member_id
     * @EndPoint /api/v1/hunt/getByMember/{member_id}
     *
     */
    @GetMapping("/getByMember/{member_id}")
    @Override
    public ResponseEntity<List<HuntingDTO>> getAllByMember(@PathVariable Integer member_id) {
        if(member_id == 0) {
            return null;
        }
        List<HuntingDTO> huntingDTOS = huntingService.getAllByMember(member_id);
        if(huntingDTOS.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(huntingDTOS);
    }
    /**
     *
     * @param competition_code
     * @return ResponseEntity<List<HuntingDTO>>
     * @description Get all huntings by competition
     * @PathVariable String competition_code
     * @EndPoint /api/v1/hunt/getByCompetition/{competition_code}
     *
     */

    @GetMapping("/getByCompetition/{competition_code}")
    @Override
    public ResponseEntity<List<HuntingDTO>> getAllByCompetition(@PathVariable String competition_code) {
        if(competition_code == null) {
            return ResponseEntity.badRequest().body(null);
        }

        List<HuntingDTO> huntingDTOS = huntingService.getAllByCompetition(competition_code);

        if(huntingDTOS.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(huntingDTOS);
    }


}
