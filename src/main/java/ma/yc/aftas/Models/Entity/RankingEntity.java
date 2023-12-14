package ma.yc.aftas.Models.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "RankingEntity")
@Table(name = "Rank")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RankingEntity {
    @EmbeddedId
    private RankEID id;

    @ManyToOne
    @JoinColumn(name = "memberNum", insertable = false, updatable = false)
    private MemberEntity member;

    @ManyToOne
    @JoinColumn(name = "competitionCode", insertable = false, updatable = false)
    private CompetitionEntity competition;

    @Basic
    @Column(name = "rank")
    private Integer rank;

    @Basic
    @Column(name = "score")
    private Integer score;

}
