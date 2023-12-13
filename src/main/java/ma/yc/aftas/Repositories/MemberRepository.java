package ma.yc.aftas.Repositories;

import ma.yc.aftas.DTO.Impl.MemberDTO;
import ma.yc.aftas.Entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {
    MemberEntity findByNum(Integer num);
}
