package com.mkandirou.aftas.ranking;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RankingDTOres {
    private RankingId rankingId;
    private Integer rank;
    private Integer score;
}
