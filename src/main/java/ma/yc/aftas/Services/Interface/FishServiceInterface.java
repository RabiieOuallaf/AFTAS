package ma.yc.aftas.Services.Interface;

import ma.yc.aftas.Models.DTO.Impl.FishDTO;

import java.util.List;

public interface FishServiceInterface {
    public FishDTO create(FishDTO fishDTO);
    public boolean deleteFish(String name);
    public FishDTO getFish(String name);
    public List<FishDTO> getAll();
}
