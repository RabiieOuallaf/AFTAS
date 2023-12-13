package ma.yc.aftas.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "HuntingEntity")
@Table(name = "huntings")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HuntingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "member_id", referencedColumnName = "num")
    private MemberEntity member;


    @Basic
    @Column(name = "numberOfFish")
    private Integer numberOfFish;

    @ManyToOne
    @JoinColumn(name = "code", referencedColumnName = "code", columnDefinition = "VARCHAR(255)")
    private CompetitionEntity competition;

    @ManyToOne
    @JoinColumn(name = "fish_id", referencedColumnName = "id")
    private FishEntity fish;


}
