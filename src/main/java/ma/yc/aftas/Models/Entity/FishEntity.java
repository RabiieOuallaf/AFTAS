package ma.yc.aftas.Models.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private List<HuntingEntity> huntings;

    @ManyToOne
    @JoinColumn(name = "level", referencedColumnName = "level")
    private LevelEntity level;

}
