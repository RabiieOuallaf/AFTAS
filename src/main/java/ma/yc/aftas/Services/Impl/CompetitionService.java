package ma.yc.aftas.Services.Impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.yc.aftas.DTO.Impl.CompetitionDTO;
import ma.yc.aftas.Entity.CompetitionEntity;
import ma.yc.aftas.Mappers.CompetitionMapper;
import ma.yc.aftas.Repositories.CompetitionRepository;
import ma.yc.aftas.Services.Interface.CompetitionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
        if(!isCompetitionDateAvailable(competitionDTO.getDate())){
            log.info("Competition date is not available");
            return null;
        }
        CompetitionEntity toBeCreatedCompetitionEntity = CompetitionMapper.competitionMapper.toEntity(competitionDTO);

        CompetitionEntity createdCompetitionEntity = competitionRepository.save(toBeCreatedCompetitionEntity);

        if(createdCompetitionEntity == null){
            log.info("Competition can't be inserted to the DB");
            return null;
        }
        return CompetitionMapper.competitionMapper.toDTO(createdCompetitionEntity);
    }

    @Override
    public boolean delete(String code) {
        CompetitionDTO competitionToBeDeleted = getByCode(code);

        if(competitionToBeDeleted == null){
            log.info("Competition not found");
            return false;
        }
        CompetitionEntity competitionToBeDeletedEntity = CompetitionMapper.competitionMapper.toEntity(competitionToBeDeleted);
        competitionRepository.delete(competitionToBeDeletedEntity);
        return true;
    }

    /**
     * @return List<CompetitionDTO>
     * @description Get all competitions
     */
    @Override
    public List<CompetitionDTO> getAll() {
        List<CompetitionEntity> listOfCompetitions = competitionRepository.findAll();
        List<CompetitionDTO> listOfCompetitionDTOs = new ArrayList<>();
        if(listOfCompetitions == null){
            log.info("No competitions found");
            return null;
        }
        listOfCompetitions.forEach(competitionEntity -> {
            listOfCompetitionDTOs.add(CompetitionMapper.competitionMapper.toDTO(competitionEntity));
        });
        return listOfCompetitionDTOs;
    }

    /**
     * @param code
     * @return CompetitionDTO
     * @description Get a competition by code
     */

    @Override
    public CompetitionDTO getByCode(String code) {
        return CompetitionMapper.competitionMapper.toDTO(competitionRepository.findByCode(code).get());
    }

    /**
     * @param date
     * @return boolean
     * @description Check if the competition date is available
     * @RequestBody : LocalDate date
     */
    @Override
    public boolean isCompetitionDateAvailable(LocalDate date) {

        CompetitionEntity foundCompetitionEntity = competitionRepository.findByDate(date);
        if(foundCompetitionEntity == null){
            return true;
        }else {
            log.warn("====================================================");
            log.warn("You can't create a competition withing 24H. please pick a date after " + date);
            log.warn("====================================================");

            return false;
        }

    }


}
