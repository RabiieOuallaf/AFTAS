package ma.yc.aftas.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.yc.aftas.Enum.IdentityDocumentType;

@Entity(name = "MemberEntity")
@Table(name = "members")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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


}
