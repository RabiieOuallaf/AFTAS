package ma.yc.aftas.Models.DTO.Impl;

import jakarta.persistence.EmbeddedId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.yc.aftas.Models.Entity.CompetitionEntity;
import ma.yc.aftas.Models.Entity.MemberEntity;
import ma.yc.aftas.Models.Entity.RankEID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RankingDTO {
    @EmbeddedId
    RankEID id;

    MemberEntity member;
    CompetitionEntity competition;
    Integer rank;
    Integer score;
}
