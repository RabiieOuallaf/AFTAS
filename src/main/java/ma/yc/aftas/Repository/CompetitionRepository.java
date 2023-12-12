package ma.yc.aftas.Repository;

import ma.yc.aftas.Entity.CompetitionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionRepository extends JpaRepository<CompetitionEntity, String> {
}
