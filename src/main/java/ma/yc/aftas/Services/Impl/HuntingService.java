package ma.yc.aftas.Services.Impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.yc.aftas.Mappers.HuntingMapper;
import ma.yc.aftas.Models.DTO.Impl.*;
import ma.yc.aftas.Models.Entity.CompetitionEntity;
import ma.yc.aftas.Models.Entity.FishEntity;
import ma.yc.aftas.Models.Entity.HuntingEntity;
import ma.yc.aftas.Models.Entity.MemberEntity;
import ma.yc.aftas.Models.Repositories.CompetitionRepository;
import ma.yc.aftas.Models.Repositories.FishRepository;
import ma.yc.aftas.Models.Repositories.HuntingRepository;
import ma.yc.aftas.Models.Repositories.MemberRepository;
import ma.yc.aftas.Services.Interface.HuntingServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor

public class HuntingService implements HuntingServiceInterface {
    @Autowired
    private final HuntingRepository huntingRepository;
    private final MemberRepository memberRepository;
    private final CompetitionRepository competitionRepository;
    private final FishRepository fishRepository;

    /**
     *
     * @param huntingDTO
     * @return HuntingDTO
     * @description Create a hunting
     */

    @Override
    public HuntingDTO create(HuntingReqDTO huntingDTO) {
        MemberEntity memberEntity = memberRepository.findByNum(huntingDTO.getMember_id());
        FishEntity fishEntity = fishRepository.findById(huntingDTO.getFish_id()).orElse(null);
        CompetitionEntity competitionEntity = competitionRepository.findByCode(huntingDTO.getCompetition_code()).orElse(null);

        if(memberEntity == null){
            log.info("Member doesn't exist");
            return null;
        }

        if(fishEntity == null){
            log.info("Fish doesn't exist");
            return null;
        }
        if(competitionEntity == null){
            log.info("Competition doesn't exist");
            return null;
        }
        HuntingEntity toBeCreatedHuntingEntity = new HuntingEntity();
        toBeCreatedHuntingEntity.setId(huntingDTO.getId());
        toBeCreatedHuntingEntity.setMember(memberEntity);
        toBeCreatedHuntingEntity.setFish(fishEntity);
        toBeCreatedHuntingEntity.setCompetition(competitionEntity);
        toBeCreatedHuntingEntity.setNumberOfFish(huntingDTO.getNumberOfFish());

        HuntingEntity createdHuntingEntity = huntingRepository.save(toBeCreatedHuntingEntity);

        return HuntingMapper.huntingMapper.toDTO(createdHuntingEntity);

    }

    /**
     *
     * @param huntingDTO
     * @return HuntingDTO
     * @description Update a hunting
     */

    @Override
    public HuntingDTO update(HuntingReqDTO huntingDTO) {
        HuntingDTO foundHunting = get(huntingDTO.getId());

        if(foundHunting == null){
            log.info("Hunting not found");
            return null;
        }

        MemberEntity memberEntity = memberRepository.findByNum(huntingDTO.getMember_id());
        FishEntity fishEntity = fishRepository.findById(huntingDTO.getFish_id()).orElse(null);
        CompetitionEntity competitionEntity = competitionRepository.findByCode(huntingDTO.getCompetition_code()).orElse(null);

        if(memberEntity == null){
            log.info("Member doesn't exist");
            return null;
        }
        if(fishEntity == null){
            log.info("Fish doesn't exist");
            return null;
        }
        if(competitionEntity == null){
            log.info("Competition doesn't exist");
            return null;
        }
        HuntingEntity toBeUpdateddHuntingEntity = new HuntingEntity();

        toBeUpdateddHuntingEntity.setId(huntingDTO.getId());
        toBeUpdateddHuntingEntity.setMember(memberEntity);
        toBeUpdateddHuntingEntity.setFish(fishEntity);
        toBeUpdateddHuntingEntity.setCompetition(competitionEntity);
        toBeUpdateddHuntingEntity.setNumberOfFish(huntingDTO.getNumberOfFish());

        HuntingEntity updateddHuntingEntity = huntingRepository.save(toBeUpdateddHuntingEntity);

        return HuntingMapper.huntingMapper.toDTO(updateddHuntingEntity);
    }
    /**
     *
     * @param id
     * @return boolean
     * @description Delete a hunting
     */


    @Override
    public boolean deleteHunting(Integer id) {
        HuntingEntity foundHuntingEntity = huntingRepository.findById(id).orElse(null);
        if(foundHuntingEntity == null){
            log.info("Hunting not found");
            return false;
        }
        huntingRepository.deleteById(id);
        return true;
    }
    /**
     *
     * @return List<HuntingDTO>
     * @description Get all huntings
     */

    @Override
    public List<HuntingDTO> getAll() {
        List<HuntingEntity> foundHuntingEntities = huntingRepository.findAll();
        List<HuntingDTO> huntingDTOS = new ArrayList<>();
        if(foundHuntingEntities.isEmpty()){
            log.info("Hunting not found");
            return null;
        }

        foundHuntingEntities.forEach(huntingEntity -> {
            HuntingDTO huntingDTO= HuntingMapper.huntingMapper.toDTO(huntingEntity);
            huntingDTOS.add(huntingDTO);
        });
        return huntingDTOS;
    }
    /**
     *
     * @param member_num
     * @return List<HuntingDTO>
     * @description Get all huntings by member
     */

    @Override
    public List<HuntingDTO> getAllByMember(Integer member_num) {
        MemberEntity memberEntity = memberRepository.findByNum(member_num);
        List<HuntingEntity> foundHuntingEntities = huntingRepository.findAllByMember(memberEntity);


        List<HuntingDTO> huntingDTOS = new ArrayList<>();
        if(foundHuntingEntities.isEmpty()){
            log.info("Hunting not found");
            return null;
        }

        foundHuntingEntities.forEach(huntingEntity -> {
            huntingEntity.getMember().setHuntings(null);
            HuntingDTO huntingDTO= HuntingMapper.huntingMapper.toDTO(huntingEntity);
            huntingDTOS.add(huntingDTO);
        });
        return huntingDTOS;
    }

    /**
     *
     * @param competition_code
     * @return List<HuntingDTO>
     * @description Get all huntings by competition
     */

    @Override
    public List<HuntingDTO> getAllByCompetition(String competition_code) {
        CompetitionEntity competitionEntity = competitionRepository.findAllByCode(competition_code);
        List<HuntingEntity> foundHuntingEntities = huntingRepository.findAllByCompetition(competitionEntity);

        if(foundHuntingEntities.isEmpty()){
            log.info("Hunting not found");
            return null;
        }
        List<HuntingDTO> huntingDTOS = new ArrayList<>();
        foundHuntingEntities.forEach(huntingEntity -> {
            huntingEntity.getCompetition().setHunting(null);
            HuntingDTO huntingDTO= HuntingMapper.huntingMapper.toDTO(huntingEntity);
            huntingDTOS.add(huntingDTO);
        });
        return huntingDTOS;
    }
    /**
     *
     * @param id
     * @return HuntingDTO
     * @description Get a hunting by id
     */

    @Override
    public HuntingDTO get(Integer id) {
        HuntingEntity foundHuntingEntity = huntingRepository.findById(id).orElse(null);
        if(foundHuntingEntity == null){
            log.info("Hunting not found");
            return null;
        }
        return HuntingMapper.huntingMapper.toDTO(foundHuntingEntity);
    }

}
