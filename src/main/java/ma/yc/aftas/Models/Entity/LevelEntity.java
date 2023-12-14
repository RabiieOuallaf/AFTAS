package ma.yc.aftas.Models.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "LevelEntity")
@Table(name = "levels")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LevelEntity {
    @Id
    @Column(name = "level")
    private Integer level;

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "points")
    private Integer points;

    @OneToMany(mappedBy = "level")
    private List<FishEntity> fish;
}
