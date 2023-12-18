package ma.yc.aftas.Services.Impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.yc.aftas.Mappers.RankingMapper;
import ma.yc.aftas.Models.DTO.Impl.RankingDTO;
import ma.yc.aftas.Models.Entity.RankingEntity;
import ma.yc.aftas.Models.Repositories.HuntingRepository;
import ma.yc.aftas.Models.Repositories.RankingRepository;
import ma.yc.aftas.Services.Interface.RankingServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RankingService implements RankingServiceInterface {
    @Autowired
    private RankingRepository rankingRepository;
    private HuntingService huntingService;


    /**
     *
     * @Desciptipn Create a new ranking
     * @param rankingDTO
     * @return RankingDTO
     *
     */
    @Override
    public RankingDTO create(RankingDTO rankingDTO) {
        RankingEntity foundRankingEntity = rankingRepository.findByCompetitionCodeAndMemberNum(rankingDTO.getCompetition().getCode() , rankingDTO.getMember().getNum());

        if(foundRankingEntity != null){
            log.info("Ranking already exists ! try to updated using the following endpoint : /ranking/update");
            return null;
        }
        RankingEntity toBeCreatedRankingEntity = RankingMapper.rankingMapper.toEntity(rankingDTO);
        RankingEntity createdRankingEntity = rankingRepository.save(toBeCreatedRankingEntity);

       if(createdRankingEntity == null){
            log.info("Ranking can't be inserted to the DB");
            return null;
        }
        return RankingMapper.rankingMapper.toDTO(createdRankingEntity);
    }

    /**
     *
     * @Description Delete a ranking
     * @param rankingDTO
     * @return boolean
     *
     */
    @Override
    public RankingDTO update(RankingDTO rankingDTO) {
        RankingEntity foundRankingEntity = rankingRepository.findByCompetitionCodeAndMemberNum(rankingDTO.getCompetition().getCode() , rankingDTO.getMember().getNum());

        if(foundRankingEntity == null){
            log.info("Ranking doesn't exist");
            return null;
        }
        RankingEntity toBeCreatedRankingEntity = RankingMapper.rankingMapper.toEntity(rankingDTO);

        RankingEntity createdRankingEntity = rankingRepository.save(toBeCreatedRankingEntity);

        if(createdRankingEntity == null){
            log.info("Ranking can't be updated");
            return null;
        }
        return RankingMapper.rankingMapper.toDTO(createdRankingEntity);
    }
    /**
     *
     * @Description Delete a ranking
     * @param competition_code
     * @param member_num
     * @return boolean
     *
     */

    @Override
    public boolean delete(String competition_code, Integer member_num) {
        RankingEntity foundRankingEntity = rankingRepository.findByCompetitionCodeAndMemberNum(competition_code , member_num);

        if(foundRankingEntity == null){
            log.info("Ranking doesn't exist");
            return false;
        }
        rankingRepository.delete(foundRankingEntity);
        return true;
    }
    /**
     *
     * @Description Get a ranking
     * @param competition_code
     * @param member_num
     * @return RankingDTO
     *
     */
    @Override
    public RankingDTO get(String competition_code, Integer member_num) {
        RankingEntity foundRankingEntity = rankingRepository.findByCompetitionCodeAndMemberNum(competition_code , member_num);

        if(foundRankingEntity == null){
            log.info("Ranking not found");
            return null;
        }
        return RankingMapper.rankingMapper.toDTO(foundRankingEntity);
    }

    /**
     *
     * @Description Get all rankings
     * @return List<RankingDTO>
     *
     */
    @Override
    public List<RankingDTO> getAll() {
        List<RankingEntity> rankingEntities = rankingRepository.findAll();
        List<RankingDTO> rankingDTOS = new ArrayList<>();

        if(rankingEntities.isEmpty()){
            log.info("No rankings found");
            return null;
        }
        rankingEntities.forEach(rankingEntity -> {
            rankingDTOS.add(RankingMapper.rankingMapper.toDTO(rankingEntity));
        });
        return rankingDTOS;
    }
    /**
     *
     * @Description Get all rankings by competition code
     * @param competition_code
     * @return List<RankingDTO>
     *
     */

    @Override
    public List<RankingDTO> getAllByCompetitionCode(String competition_code) {
        List<RankingEntity> rankingEntities = rankingRepository.findAllByCompetitionCode(competition_code);
        List<RankingDTO> rankingDTOS = new ArrayList<>();

        if(rankingEntities.isEmpty()){
            log.info("No rankings found");
            return null;
        }
        rankingEntities.forEach(rankingEntity -> {
            rankingDTOS.add(RankingMapper.rankingMapper.toDTO(rankingEntity));
        });
        return rankingDTOS;
    }
    /**
     *
     * @Description Get all rankings by member num
     * @param member_num
     * @return List<RankingDTO>
     *
     */
    @Override
    public List<RankingDTO> getAllByMemberNum(Integer member_num) {
        List<RankingEntity> rankingEntities = rankingRepository.findAllByMemberNum(member_num);
        List<RankingDTO> rankingDTOS = new ArrayList<>();

        if(rankingEntities.isEmpty()){
            log.info("No rankings found");
            return null;
        }
        rankingEntities.forEach(rankingEntity -> {
            rankingDTOS.add(RankingMapper.rankingMapper.toDTO(rankingEntity));
        });
        return rankingDTOS;
    }


}
