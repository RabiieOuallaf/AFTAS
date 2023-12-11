package ma.yc.aftas.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "RankingEntity")
@Table(name = "rankings")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RankingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "rank")
    private Integer rank;

    @Basic
    @Column(name = "score")
    private Integer score;

}
