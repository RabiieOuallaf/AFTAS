package ma.yc.aftas.Models.DTO.Impl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FishReqDTO {
    String name;
    Float averageWeight;
    Integer level;
}
