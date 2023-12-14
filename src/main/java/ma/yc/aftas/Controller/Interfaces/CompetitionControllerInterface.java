package ma.yc.aftas.Controller.Interfaces;

import ma.yc.aftas.Models.DTO.Impl.CompetitionDTO;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public interface CompetitionControllerInterface {
    public ResponseEntity<String> create(CompetitionDTO competitionDTO);
    public ResponseEntity<String> delete(String code);
    public ResponseEntity<List<CompetitionDTO>> getAll();
    public Object getByCode(String code);

    public String generateCode(LocalDate startDate, String location);

}
