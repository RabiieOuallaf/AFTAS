package ma.yc.aftas.Services.Interface;

import ma.yc.aftas.DTO.Impl.MemberDTO;
import java.util.List;

public interface MemberServiceInterface {
    public MemberDTO create(MemberDTO memberDTO);
    public MemberDTO update(MemberDTO memberDTO);
    public boolean delete(Integer num);
    public List<MemberDTO> getAll();
    public MemberDTO getByNum(Integer num);
}
