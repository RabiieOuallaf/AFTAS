package ma.yc.aftas.Controller.Interfaces;

import ma.yc.aftas.Models.DTO.Impl.RankingDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RankingControllerInterface {

    ResponseEntity<RankingDTO> get(String competition_code, Integer member_num);
    ResponseEntity<List<RankingDTO>> getAll();
    ResponseEntity<List<RankingDTO>> getAllByCompetitionCode(String competition_code);
    ResponseEntity<List<RankingDTO>> getAllByMemberNum(Integer member_num);
    ResponseEntity<List<RankingDTO>> getAndSortRankingByCompetition(String competition_code);
    ResponseEntity<List<RankingDTO>> getCompetitionPoduim(String competition_code);
    ResponseEntity<String> delete(String competition_code, Integer member_num);

}
