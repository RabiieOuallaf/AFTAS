package ma.yc.aftas.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "MemberEntity")
@Table(name = "members")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberEntity {
    @Id
    private Long id;

}
