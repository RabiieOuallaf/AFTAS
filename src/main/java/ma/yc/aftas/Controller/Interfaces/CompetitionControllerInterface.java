package ma.yc.aftas.Controller.Interfaces;

import ma.yc.aftas.DTO.Impl.CompetitionDTO;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Date;

public interface CompetitionControllerInterface {
    public ResponseEntity<String> create(CompetitionDTO competitionDTO);
    public ResponseEntity<String> update(CompetitionDTO competitionDTO);
    public ResponseEntity<String> delete(CompetitionDTO competitionDTO);
    public ResponseEntity<String> getAll();
    public ResponseEntity<String> getByCode(String code);

    public String generateCode(LocalDate startDate, String location);
}
