package ma.yc.aftas.Models.DTO.Impl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.yc.aftas.Models.Entity.FishEntity;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LevelDTO {
    Integer level;
    String description;
    Integer points;
}
