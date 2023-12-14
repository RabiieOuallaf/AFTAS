package ma.yc.aftas.Services.Interface;

import ma.yc.aftas.Models.DTO.Impl.FishDTO;
import ma.yc.aftas.Models.DTO.Impl.FishReqDTO;

import java.util.List;

public interface FishServiceInterface {
    FishDTO create(FishReqDTO fishReqDTO);
    boolean deleteFish(String name);
    FishDTO getFish(String name);
    List<FishDTO> getAll();
}
