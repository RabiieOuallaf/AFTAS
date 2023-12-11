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

    @Basic
    @Column(name = "numberOfFish")
    private Integer numberOfFish;


}
