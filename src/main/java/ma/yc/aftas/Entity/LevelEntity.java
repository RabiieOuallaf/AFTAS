package ma.yc.aftas.Entity;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code")
    private Integer code;

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "points")
    private Integer points;

    @OneToMany(mappedBy = "level")
    private List<FishEntity> fish;
}
