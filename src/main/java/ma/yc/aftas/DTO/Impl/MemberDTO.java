package ma.yc.aftas.DTO.Impl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.yc.aftas.Enum.IdentityDocumentType;

import java.util.Date;

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
}
