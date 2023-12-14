package ma.yc.aftas.Models.Repositories;

import ma.yc.aftas.Models.Entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {
    MemberEntity findByNum(Integer num);
}
