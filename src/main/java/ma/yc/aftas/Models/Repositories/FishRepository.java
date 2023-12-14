package ma.yc.aftas.Models.Repositories;

import ma.yc.aftas.Models.DTO.Impl.FishDTO;
import ma.yc.aftas.Models.Entity.FishEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FishRepository extends JpaRepository<FishEntity, Integer> {
    FishEntity findByName(String name);
}
