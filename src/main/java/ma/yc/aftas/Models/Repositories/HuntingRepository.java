package ma.yc.aftas.Models.Repositories;

import ma.yc.aftas.Models.Entity.HuntingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HuntingRepository extends JpaRepository<HuntingEntity,Integer> {
}
