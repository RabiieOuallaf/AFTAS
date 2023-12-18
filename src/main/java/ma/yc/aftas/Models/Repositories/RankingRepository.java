package ma.yc.aftas.Models.Repositories;

import ma.yc.aftas.Models.Entity.RankEID;
import ma.yc.aftas.Models.Entity.RankingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankingRepository extends JpaRepository<RankingEntity, RankEID> {
    RankingEntity findByCompetitionCodeAndMemberNum(String competition_code , Integer member_num);

    List<RankingEntity> findAllByCompetitionCode(String competitionCode);

    List<RankingEntity> findAllByMemberNum(Integer memberNum);
}
