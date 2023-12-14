package ma.yc.aftas.Models.Repositories;

import ma.yc.aftas.Models.Entity.RankEID;
import ma.yc.aftas.Models.Entity.RankingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankingRepository extends JpaRepository<RankingEntity, RankEID> {
}
