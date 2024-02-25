package com.mkandirou.aftas.auth;


import com.mkandirou.aftas.app_user.IdentityDocumentType;
import com.mkandirou.aftas.app_user.Role;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
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
