package ma.yc.aftas.Services.Interface;

import ma.yc.aftas.Models.DTO.Impl.RankingDTO;

import java.util.List;

public interface RankingServiceInterface {
    RankingDTO create(RankingDTO rankingDTO);
    RankingDTO update(RankingDTO rankingDTO);
    boolean delete(String competition_code, Integer member_num);
    RankingDTO get(String competition_code, Integer member_num);
    List<RankingDTO> getAll();
    List<RankingDTO> getAllByCompetitionCode(String competition_code);
    List<RankingDTO> getAllByMemberNum(Integer member_num);
    List<RankingDTO> getAndSortRankingByCompetition(String competition_code);
}
