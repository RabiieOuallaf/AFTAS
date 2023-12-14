package ma.yc.aftas.Models.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class RankEID implements Serializable {
    @Column(name = "memberNum")
    private Integer memberNum;

    @Column(name = "competitionCode")
    private String competitionCode;

}
