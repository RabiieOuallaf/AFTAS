package ma.yc.aftas.DTO.Impl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.yc.aftas.Entity.CompetitionEntity;
import ma.yc.aftas.Entity.HuntingEntity;
import ma.yc.aftas.Enum.IdentityDocumentType;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    Integer number;
    String name;
    String familyName;
    Date accessionDate;
    IdentityDocumentType identityDocumentType;
    String IdentityNumber;
    Set<CompetitionEntity> competitions;
    List<HuntingEntity> huntings;

}
