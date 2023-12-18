package ma.yc.aftas.Models.DTO.Impl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HuntingReqDTO {
    Integer id;
    Integer numberOfFish;
    Integer member_id;
    String competition_code;
    Integer fish_id;
}
