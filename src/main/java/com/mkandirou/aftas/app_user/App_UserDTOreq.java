package com.mkandirou.aftas.app_user;


import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class App_UserDTOreq {
    private Integer num;
    @NotNull(message = "name is required")
    private String name;
    @NotNull(message = "email is required")
    private String email;
    @NotNull(message = "familyName is required")
    private String familyName;
    @NotNull(message = "password is required")
    private String password;
    @NotNull(message = "accessionDate is required")
    private LocalDate accessionDate;
    @NotNull(message = "nationality is required")
    private String nationality;
    @NotNull(message = "IdentityDocument is required")
    private IdentityDocumentType identityDocument;
    @NotNull(message = "IdentityNumber is required")
    private String identityNumber;
    @NotNull(message = "role is required")
    private Role role;
}
