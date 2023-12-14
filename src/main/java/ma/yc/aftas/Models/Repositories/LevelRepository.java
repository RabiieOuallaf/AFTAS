package ma.yc.aftas.Models.Repositories;

import ma.yc.aftas.Models.Entity.LevelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelRepository extends JpaRepository<LevelEntity, Integer> {
    LevelEntity findByLevel(Integer level);
}
