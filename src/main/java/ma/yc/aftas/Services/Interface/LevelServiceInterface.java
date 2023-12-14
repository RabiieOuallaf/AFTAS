package ma.yc.aftas.Services.Interface;

import ma.yc.aftas.Models.DTO.Impl.LevelDTO;
import java.util.List;

public interface LevelServiceInterface {
    LevelDTO create(LevelDTO levelDTO);
    boolean delete(Integer level);
    List<LevelDTO> getAll();
    LevelDTO get(Integer level);
}
