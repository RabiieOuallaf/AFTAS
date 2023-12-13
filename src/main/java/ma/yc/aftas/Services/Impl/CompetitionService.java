package ma.yc.aftas.Services.Impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.yc.aftas.DTO.Impl.CompetitionDTO;
import ma.yc.aftas.Entity.CompetitionEntity;
import ma.yc.aftas.Mappers.CompetitionMapper;
import ma.yc.aftas.Repositories.CompetitionRepository;
import ma.yc.aftas.Services.Interface.CompetitionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class CompetitionService implements CompetitionServiceInterface {
    @Autowired
    private CompetitionRepository competitionRepository;
    /**
    * @param competitionDTO
    * @return CompetitionDTO
    * @description Create a competition
     */
    @Override
    public CompetitionDTO create(CompetitionDTO competitionDTO) {
        Optional<CompetitionEntity> competitionEntity = competitionRepository.findByCode(competitionDTO.getCode());

        if(competitionEntity.isPresent()){
            log.info("Competition already exists");
            return null;
        }
        System.out.print("CompetitionDTO from service ----->: "+competitionDTO);
        CompetitionEntity toBeCreatedCompetitionEntity = CompetitionMapper.competitionMapper.toEntity(competitionDTO);
        System.out.print("CompetitionDTO to be created from service ----->: "+toBeCreatedCompetitionEntity);

        CompetitionEntity createdCompetitionEntity = competitionRepository.save(toBeCreatedCompetitionEntity);
        System.out.print("CompetitionDTO created from service ----->: "+createdCompetitionEntity);

        if(createdCompetitionEntity == null){
            log.info("Competition not created");
            return null;
        }
        return CompetitionMapper.competitionMapper.toDTO(createdCompetitionEntity);
    }

    @Override
    public CompetitionDTO update(CompetitionDTO competitionDTO) {
        return null;
    }

    @Override
    public CompetitionDTO delete(CompetitionDTO competitionDTO) {
        return null;
    }

    @Override
    public CompetitionDTO getAll() {
        return null;
    }

    @Override
    public CompetitionDTO getByCode(String code) {
        return null;
    }

    @Override
    public boolean isCompetitionDateValid(CompetitionDTO competitionDTO) {
        return false;
    }


}
