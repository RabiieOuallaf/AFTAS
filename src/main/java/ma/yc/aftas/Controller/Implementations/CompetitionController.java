package ma.yc.aftas.Controller.Implementations;

import lombok.RequiredArgsConstructor;
import ma.yc.aftas.Controller.Interfaces.CompetitionControllerInterface;
import ma.yc.aftas.DTO.Impl.CompetitionDTO;
import ma.yc.aftas.Services.Impl.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/competition")
public class CompetitionController implements CompetitionControllerInterface {

    @Autowired
    private CompetitionService competitionService;
    /**
     * Create a competition
     * @param competitionDTO
     * @return ResponseEntity<String>
     * @Endpoint : /api/v1/competition/create
     */
    @PostMapping("/create")
    @Override
    public ResponseEntity<String> create(@RequestBody CompetitionDTO competitionDTO) {
        if(competitionDTO.getStartTime() == null || competitionDTO.getLocation() == null || competitionDTO.getEndTime() == null) {
            return ResponseEntity.badRequest().body("Invalid request");
        }
        competitionDTO.setCode(generateCode(competitionDTO.getDate(), competitionDTO.getLocation()));
        CompetitionDTO createdCompetitionDTO = competitionService.create(competitionDTO);
        if(createdCompetitionDTO == null){
            return ResponseEntity.badRequest().body("Competition can't be created check the logs");
        }
        return ResponseEntity.ok().body("Created competition object :" + createdCompetitionDTO);

    }

    @DeleteMapping("/delete/{code}")
    @Override

    /**
     * Delete a competition
     * @param code
     * @return ResponseEntity<String>
     * @Endpoint : /api/v1/competition/delete/{code}
     */
    public ResponseEntity<String> delete(@PathVariable String code) {

        if(competitionService.delete(code)){
            return ResponseEntity.ok().body("Competition deleted successfully");
        }else {
            return ResponseEntity.badRequest().body("Competition not found");
        }
    }

    @GetMapping("/getAll")
    @Override

    /**
     * Get all competitions
     * @return ResponseEntity<List<CompetitionDTO>>
     * @Endpoint : /api/v1/competition/getAll
     */

    public ResponseEntity<List<CompetitionDTO>> getAll() {
        return ResponseEntity.ok().body(competitionService.getAll());
    }

    @GetMapping("/get/{code}")
    @Override

    /**
     * Get a competition by code
     * @param code
     * @return ResponseEntity<String>
     * @Endpoint : /api/v1/competition/get/{code}
     */

    public ResponseEntity<String> getByCode(@PathVariable String code) {
        CompetitionDTO foundCompetitionDTO = competitionService.getByCode(code);

        if(foundCompetitionDTO == null){
            return ResponseEntity.badRequest().body("Competition not found");
        }
        return ResponseEntity.ok().body("Competition found : " + foundCompetitionDTO);
    }

    /**
     * @param date
     * @return boolean
     * @description Check if the competition date is available
     * @RequestBody : LocalDate date
     */

    @Override
    public String generateCode(LocalDate date, String location) {
        if (date == null || location == null) {
            throw new IllegalArgumentException("Date and location cannot be null");
        }
        String locationCode = location.substring(0, Math.min(location.length(), 3)).toLowerCase();
        String dateCode = date.toString().substring(2, 4) + "-" +
                String.format("%02d", date.getMonthValue()) + "-" +
                String.format("%02d", date.getDayOfMonth());

        return locationCode + "-" + dateCode;
    }




}
