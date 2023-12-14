package ma.yc.aftas.Services.Interface;

import ma.yc.aftas.Models.DTO.Impl.CompetitionDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface CompetitionServiceInterface {
    public CompetitionDTO create(CompetitionDTO competitionDTO);
    public boolean delete(String code);
    public List<CompetitionDTO> getAll();
    public CompetitionDTO getByCode(String code);
    public boolean isCompetitionDateAvailable(LocalDate competitionDate);

}
