package ma.yc.aftas.Controller.Interfaces;

import ma.yc.aftas.Models.DTO.Impl.HuntingDTO;
import ma.yc.aftas.Models.DTO.Impl.HuntingReqDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HuntingControllerInterface {
    ResponseEntity<String> create(HuntingReqDTO huntingDTO);
    ResponseEntity<String> update(HuntingReqDTO huntingDTO);
    ResponseEntity<Object> deleteHunting(Integer id);
    ResponseEntity<List<HuntingDTO>> getAll();
    ResponseEntity<List<HuntingDTO>> getAllByMember(Integer member_id);
    ResponseEntity<List<HuntingDTO>> getAllByCompetition(String competition_code);
    ResponseEntity<HuntingDTO> get(Integer hunt_id);
}
