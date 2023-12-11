package ma.yc.aftas.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "FishEntity")
@Table(name = "fishs")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FishEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "average_weight")
    private Float averageWeight;

    @OneToMany(mappedBy = "fish")
    private List<HuntingEntity> huntings;

    @ManyToOne
    @JoinColumn(name = "level_id", referencedColumnName = "id")
    private LevelEntity level;

}
