package ma.yc.aftas.Services.Interface;

import ma.yc.aftas.DTO.Impl.CompetitionDTO;
import ma.yc.aftas.Entity.CompetitionEntity;
import org.springframework.stereotype.Service;

@Service
public interface CompetitionServiceInterface {
    public CompetitionDTO create(CompetitionDTO competitionDTO);
    public CompetitionDTO update(CompetitionDTO competitionDTO);
    public CompetitionDTO delete(CompetitionDTO competitionDTO);
    public CompetitionDTO getAll();
    public CompetitionDTO getByCode(String code);
    public boolean isCompetitionDateValid(CompetitionDTO competitionDTO);
}
