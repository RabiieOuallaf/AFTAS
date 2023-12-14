package ma.yc.aftas.Services.Interface;

import ma.yc.aftas.Models.DTO.Impl.MemberDTO;
import java.util.List;

public interface MemberServiceInterface {
    MemberDTO create(MemberDTO memberDTO);
    MemberDTO update(MemberDTO memberDTO);
    boolean delete(Integer num);
    List<MemberDTO> getAll();
    MemberDTO getByNum(Integer num);
}
