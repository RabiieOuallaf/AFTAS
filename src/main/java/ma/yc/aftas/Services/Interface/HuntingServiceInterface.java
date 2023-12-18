package ma.yc.aftas.Services.Interface;

import ma.yc.aftas.Models.DTO.Impl.HuntingDTO;
import ma.yc.aftas.Models.DTO.Impl.HuntingReqDTO;
import ma.yc.aftas.Models.DTO.Impl.MemberDTO;
import ma.yc.aftas.Models.DTO.Impl.RankingDTO;

import java.util.List;

public interface HuntingServiceInterface {
    HuntingDTO create(HuntingReqDTO huntingDTO);
    HuntingDTO update(HuntingReqDTO huntingDTO);
    boolean deleteHunting(Integer id);
    List<HuntingDTO> getAll();
    List<HuntingDTO> getAllByMember(Integer member_id);
    List<HuntingDTO> getAllByCompetition(String competition_code);
    HuntingDTO get(Integer id);
    Integer calculateScore(Integer hunting_id);
    RankingDTO setRanking(Integer hunting_id);


}
