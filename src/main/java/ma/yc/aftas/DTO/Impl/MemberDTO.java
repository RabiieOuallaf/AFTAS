package ma.yc.aftas.DTO.Impl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.yc.aftas.Enum.IndentityDocumentType;

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
    IndentityDocumentType indentityDocumentType;
    String IdentityNumber;
}
