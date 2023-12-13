package ma.yc.aftas.Controller.Interfaces;

import ma.yc.aftas.DTO.Impl.MemberDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MemberControllerInterface {
    public ResponseEntity<String> create(MemberDTO memberDTO);
    public ResponseEntity<String> update(MemberDTO memberDTO);
    public ResponseEntity<String> delete(Integer num);
    public ResponseEntity<List<MemberDTO>> getAll();
    public ResponseEntity<MemberDTO> getByNum(Integer num);
}
