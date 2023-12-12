package ma.yc.aftas.Repositories;

import ma.yc.aftas.Entity.RankEID;
import ma.yc.aftas.Entity.RankingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankingRepository extends JpaRepository<RankingEntity, RankEID> {
}
