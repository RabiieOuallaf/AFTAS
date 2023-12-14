package ma.yc.aftas.Models.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.yc.aftas.Enum.IdentityDocumentType;

import java.util.List;
import java.util.Set;

@Entity(name = "MemberEntity")
@Table(name = "members")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberEntity {
    @Id
    @Column(name = "num")
    private Integer num;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "familyName")
    private String familyName;

    @Basic
    @Column(name = "accessionDate")
    private String accessionDate;

    @Basic
    @Column(name = "nationality")
    private String nationality;

    @Basic
    @Column(name = "identityDocumentType")
    private IdentityDocumentType identityDocumentType;

    @Basic
    @Column(name = "identityDocumentNumber")
    private String identityDocumentNumber;

    @ManyToMany
    @JoinTable(
            name = "Rank",
            joinColumns = @JoinColumn(name = "memberNum"),
            inverseJoinColumns = @JoinColumn(name = "competitionCode")
    )

    private Set<CompetitionEntity> competitions;

    @OneToMany(mappedBy = "member")
    private List<HuntingEntity> huntings;

}
