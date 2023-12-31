package ma.yc.aftas.Models.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name = "level")
    private Integer level;

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "points")
    private Integer points;

    @OneToMany(mappedBy = "level", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<FishEntity> fish;
}
