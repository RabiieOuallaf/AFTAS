package ma.yc.aftas.DTO.Impl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RankingDTO {
    Integer id;
    Integer rank;
    Integer score;
}
