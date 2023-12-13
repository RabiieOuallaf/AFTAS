package ma.yc.aftas.Repositories;

import ma.yc.aftas.Entity.CompetitionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface CompetitionRepository extends JpaRepository<CompetitionEntity, String> {
    Optional<CompetitionEntity> findByCode(String code);
    CompetitionEntity findByDate(LocalDate date);
}
