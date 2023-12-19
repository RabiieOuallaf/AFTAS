package ma.yc.aftas.Controller.Implementations;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.yc.aftas.Controller.Interfaces.RankingControllerInterface;
import ma.yc.aftas.Models.DTO.Impl.RankingDTO;
import ma.yc.aftas.Services.Impl.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/rank")
@Slf4j
public class RankingController implements RankingControllerInterface {
    @Autowired
    private final RankingService rankingService;

    /**
     *
     * @param competition_code member_num
     * @return ResponseEntity<String>
     * @description Create a ranking
     * @Endpoint: POST /api/v1/rank/create
     *
     */
    @GetMapping("/get/{competition_code}/{member_num}")
    @Override
    public ResponseEntity<RankingDTO> get(@PathVariable String competition_code, Integer member_num) {
        if(competition_code.isEmpty() || member_num == 0){
            return ResponseEntity.badRequest().body(null);
        }
        RankingDTO foundRankingDTO = rankingService.get(competition_code, member_num);
        if(foundRankingDTO == null){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(foundRankingDTO);
    }

    /**
     * @Description Create rankings
     * @return ResponseEntity<String>
     */
    @GetMapping("/getAll")
    @Override
    public ResponseEntity<List<RankingDTO>> getAll() {
        List<RankingDTO> rankingDTOList = rankingService.getAll();
        if(rankingDTOList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(rankingDTOList);
    }

    /**
     *
     * @param competition_code
     * @return ResponseEntity<String>
     * @description Create a ranking
     * @Endpoint: POST /api/v1/rank/create
     *
     */

    @GetMapping("/getAllByCompetitionCode/{competition_code}")
    @Override
    public ResponseEntity<List<RankingDTO>> getAllByCompetitionCode(@PathVariable String competition_code) {
       if(competition_code.isEmpty()){
           return ResponseEntity.badRequest().body(null);
       }
       List<RankingDTO> rankingDTOList = rankingService.getAllByCompetitionCode(competition_code);
       if(rankingDTOList.isEmpty()) {
           return ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok().body(rankingDTOList);
    }
    /**
     *
     * @param member_num
     * @return ResponseEntity<String>
     * @description Create a ranking
     * @Endpoint: POST /api/v1/rank/create
     *
     */
    @GetMapping("/getAllByMemberNum/{member_num}")
    @Override
    public ResponseEntity<List<RankingDTO>> getAllByMemberNum(Integer member_num) {
        if(member_num == 0){
            return ResponseEntity.badRequest().body(null);
        }
        List<RankingDTO> rankingDTOList = rankingService.getAllByMemberNum(member_num);
        if(rankingDTOList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(rankingDTOList);
    }

    /**
     *
     * @param competition_code
     * @return ResponseEntity<String>
     * @description Create a ranking
     * @Endpoint: POST /api/v1/rank/create
     *
     */
    @GetMapping("/getAndSortRankingByCompetition/{competition_code}")
    @Override
    public ResponseEntity<List<RankingDTO>> getAndSortRankingByCompetition(String competition_code) {
       if(competition_code.isEmpty()){
           return ResponseEntity.badRequest().body(null);
       }
       List<RankingDTO> rankingDTOList = rankingService.getAndSortRankingByCompetition(competition_code);
       if(rankingDTOList.isEmpty()){
           return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(rankingDTOList);
    }

    /**
     *
     * @param competition_code
     * @return ResponseEntity<String>
     * @description Create a ranking
     * @Endpoint: POST /api/v1/rank/create
     *
     */

    @GetMapping("/getCompetitionPoduim/{competition_code}")
    @Override
    public ResponseEntity<List<RankingDTO>> getCompetitionPoduim(@PathVariable String competition_code) {
        if(competition_code.isEmpty()){
            return ResponseEntity.badRequest().body(null);
        }
        List<RankingDTO> rankingDTOList = rankingService.getCompetitionPoduim(competition_code);
        if(rankingDTOList == null || rankingDTOList.isEmpty() ){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(rankingDTOList);
    }

    /**
     * @Description Create a ranking
     * @param competition_code
     * @param member_num
     * @return ResponseEntity<String>
     */
    @DeleteMapping("/delete/{competition_code}/{member_num}")
    @Override
    public ResponseEntity<String> delete(String competition_code, Integer member_num) {
        if(competition_code.isEmpty() || member_num == 0){
            return ResponseEntity.badRequest().body("Invalid request");
        }
        if(rankingService.delete(competition_code, member_num)) {
            return ResponseEntity.ok().body("Ranking deleted successfully");
        }
        return ResponseEntity.badRequest().body("Ranking not found");
    }
}
