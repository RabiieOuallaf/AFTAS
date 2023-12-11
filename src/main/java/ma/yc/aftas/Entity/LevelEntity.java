package ma.yc.aftas.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "LevelEntity")
@Table(name = "levels")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LevelEntity {
    @Id
    private Long id;

}
