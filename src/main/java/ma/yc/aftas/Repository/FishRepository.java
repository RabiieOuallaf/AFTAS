package ma.yc.aftas.Repository;

import ma.yc.aftas.Entity.FishEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FishRepository extends JpaRepository<FishEntity, Integer> {
}
