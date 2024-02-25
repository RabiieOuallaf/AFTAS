package com.mkandirou.aftas.app_user;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class App_UserDTOres {
    private Integer num;
    private String name;
    private String familyName;
    private String email;
    private String password;
    private LocalDate accessionDate;
    private String nationality;
    private IdentityDocumentType identityDocument;
    private String identityNumber;
    private Role role;
}
