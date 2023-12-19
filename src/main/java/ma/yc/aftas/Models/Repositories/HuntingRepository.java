package ma.yc.aftas.Models.Repositories;

import ma.yc.aftas.Models.Entity.CompetitionEntity;
import ma.yc.aftas.Models.Entity.HuntingEntity;
import ma.yc.aftas.Models.Entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HuntingRepository extends JpaRepository<HuntingEntity,Integer> {

    List<HuntingEntity> findAllByMember(MemberEntity memberEntity);

    List<HuntingEntity> findAllByCompetition(CompetitionEntity competitionEntity);

    List<HuntingEntity> findByCompetitionCodeAndFishIdAndMemberNum(String competitionCode, Integer fishId, Integer memberId);
}
