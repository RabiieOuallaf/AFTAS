package ma.yc.aftas.Models.DTO.Impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.yc.aftas.Models.Entity.CompetitionEntity;
import ma.yc.aftas.Models.Entity.HuntingEntity;
import ma.yc.aftas.Enum.IdentityDocumentType;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    Integer num;
    String name;
    String familyName;
    Date accessionDate;
    IdentityDocumentType identityDocumentType;
    String identityDocumentNumber;
}
