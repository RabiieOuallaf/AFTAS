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

    @Override
    public ResponseEntity<String> update(CompetitionDTO competitionDTO) {
        return null;

    }

    @Override
    public ResponseEntity<String> delete(CompetitionDTO competitionDTO) {
        return null;
    }

    @GetMapping("/getAll")
    @Override
    public ResponseEntity<List<CompetitionDTO>> getAll() {
        return ResponseEntity.ok().body(competitionService.getAll());
    }

    @Override
    public ResponseEntity<String> getByCode(String code) {
        return null;
    }

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
